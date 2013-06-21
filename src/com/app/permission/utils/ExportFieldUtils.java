package com.app.permission.utils;

public class ExportFieldUtils {
	public static void export(String... fields) {
		for(String str:fields){
			System.out.println("private String s_"+str+";");
			System.out.println("private String e_"+str+";");
		}
	}

	public static void main(String[] args) {
		String[] strs = {
			"ldzch",
			"hbzj",
			"jyxjrzch",
			"yshpj",
			"yshzhk",
			"fkx",
			"yshlx",
			"yshgl",
			"qtyshk",
			"ck",
			"yndqdezch",
			"qtldzch",
			"ldzchhj",
			"fldzch",
			"kgjrzch",
			"chydqtz",
			"chyshk",
			"chqgqtz",
			"tzxfdch",
			"gdzch",
			"zjgch",
			"gchwz",
			"gdzchql",
			"shchxshwzch",
			"yqzch",
			"wxzch",
			"kfzch",
			"shy",
			"chqdtfy",
			"dysdshzch",
			"qtfldzch",
			"flhj",
			"zchzj",
			"ldfzh",
			"dqjk",
			"jyxjrfzh",
			"yfpj",
			"yfzhk",
			"yshkx",
			"yfzhgxch",
			"yjshf",
			"yflx",
			"yfgx",
			"qtyfk",
			"yndqfldfzh",
			"qtldfzh",
			"ldfzhhj",
			"fldfzh",
			"chqjk",
			"yfzhq",
			"chqyfk",
			"zhxyfk",
			"yjfzh",
			"dyfdshfzh",
			"qtfldfzh",
			"fldfzhhj",
			"fzhhj",
			"syzhqy",
			"shshzb",
			"zbgj",
			"kcg",
			"yygj",
			"wfplr",
			"syzhqyhj",
			"fzhhshyzh"
		};
		ExportFieldUtils.export(strs);
	}
}
