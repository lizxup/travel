package com.example.controller;

import com.example.common.Result;
import com.example.entity.Travels;
import com.example.service.TravelsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/travels")
public class TravelsController {

    @Autowired
    private TravelsService travelsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Travels travels) {
        travelsService.add(travels);
        return Result.success(travels);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result update(@RequestBody Travels travels) {
        travelsService.updateById(travels);
        return Result.success();
    }

    /**
     * 单个删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        travelsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        travelsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 单个查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Travels travels = travelsService.selectById(id);
        return Result.success(travels);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Travels travels) {
        List<Travels> list = travelsService.selectAll(travels);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Travels travels,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Travels> pageInfo = travelsService.selectPage(travels, pageNum, pageSize);
        return Result.success(pageInfo);

    }

    /**
     * 只查询用户可见的游记
     * @param travels
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectFrontPage")
    public Result selectFrontPage(Travels travels,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Travels> pageInfo = travelsService.selectFrontPage(travels, pageNum, pageSize);
        return Result.success(pageInfo);

    }

    @PutMapping("/updateReadCount/{id}")
    public Result updateReadCount(@PathVariable Integer id){
        travelsService.updateReadCount(id);
        return Result.success();
    }
}
