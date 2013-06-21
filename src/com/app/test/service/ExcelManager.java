package com.app.test.service;

import org.springframework.stereotype.Service;

import com.app.test.model.ExcelModel;

import com.app.permission.utils.excel.GenerateExcel;

@Service
public class ExcelManager extends GenerateExcel<ExcelModel> {

}
