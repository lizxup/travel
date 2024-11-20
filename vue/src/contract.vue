const validatePass = (rule, value, callback) => {
if (!value) {
callback(new Error('请确认密码'))
} else {
if (value !== data.form.password) {
callback(new Error("确认密码跟原密码不一致!"))
}
callback()
}
}

const data = reactive({
form: { },
rules: {
username: [
{ required: true, message: '请输入账号', trigger: 'blur' }
],
password: [
{ required: true, message: '请输入密码', trigger: 'blur' }
],
confirmPassword: [
{ validator: validatePass, trigger: 'blur' }
]
}
})