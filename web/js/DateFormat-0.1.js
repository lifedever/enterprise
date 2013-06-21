/*
	Name : DataFormat.js
	CreateTime : 2011-11-24
	Author : そよ风 (gudehsiao[at]gmail.com)
	LastEdit : 2011-11-25
*/
(function () {
	if (!window.DateFormat) {
		var DateFormat = {};

		DateFormat._month = ["January", "February", "March", "April",
				"May", "June", "July", "August", "September",
				"October", "November", "December"];
		DateFormat._week = ["Sundy", "Mondy", "Tuesday", "Wednesday",
				"Thursday", "Friday", "Saturday"];
		DateFormat._monthDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

		DateFormat.addLeadingZero = function (a, b) {
			if (a < b) {
				return '0' + a;
			} else {
				return a;
			}
		};


		DateFormat.Init = function (a, b) {
			this._formatString = a;
			this._date = b ? b : new Date();
		};
		
		//functions
		DateFormat.y = function () {
			return this._date.getFullYear().toString().substr(-2, 2);
		};
		DateFormat.Y = function () {
			return this._date.getFullYear();
		};
		DateFormat.n = function () {
			return this._date.getMonth() + 1;
		};
		DateFormat.j = function () {
			return this._date.getDate();
		};
		DateFormat.d = function () {
			return this.addLeadingZero(this.j(), 10);
		};
		DateFormat.m = function () {
			return this.addLeadingZero(this.n(), 10);
		};
		DateFormat.w = function () {
			return this._date.getDay();
		};
		DateFormat.l = function () {
			return this._week[this.w()];
		};
		DateFormat.F = function () {
			return this._month[this.n()];
		};
		DateFormat.M = function () {
			return this.F().substr(0, 3);
		};
		DateFormat.L = function () {
			var intYear = parseInt(this.Y());
			if (intYear % 4 == 0 && intYear % 100 != 0 || intYear % 400 == 0) {
				return 1;
			} else {
				return 0;
			}
		};
		DateFormat.t = function () {
			var month = this._date.getMonth();
			if (month == 1 && this.L()) {
				return 29;
			} else {
				return this._monthDay[month];
			}
		};
		DateFormat.r = function () {
			return this._date.toString();
		};
		DateFormat.G = function () {
			return this._date.getHours();
		};
		DateFormat.H = function () {
			return this.addLeadingZero(this.G(), 10);
		};
		DateFormat.g = function () {
			var t = this.G() + 1;
			if (t > 12) {
				t = t - 12;
			}
			return t;
		};
		DateFormat.h = function () {
			return this.addLeadingZero(this.g, 10);
		};
		DateFormat.a = function () {
			if (this.G > 12) {
				return 'pm';
			} else {
				return 'am';
			}
		};
		DateFormat.A = function () {
			return this.a().toUpperCase();
		};
		DateFormat.i = function () {
			return this.addLeadingZero(this._date.getMinutes(), 10);
		};
		DateFormat.s = function () {
			return this.addLeadingZero(this._date.getSeconds(), 10);
		};
		DateFormat.D = function () {
			return this.l().slice(0, 3);
		};
		DateFormat.N = function () {
			return this.w() + 1;
		};
		DateFormat.z = function () {
			var d = new Date(this.Y(), 0, 1);
			return Math.ceil((this._date - d) / 86400000);
		};
		DateFormat.U = function () {
			return this._date.getTime();
		};
		
		//get result
		DateFormat._get = function (match) {
			return DateFormat[match]();
		};
		DateFormat.Get = function () {
			return this._formatString.replace(/\b(\w+)\b/g,this._get);
		};
		window.DateFormat = DateFormat;
		
		//support prototype
		Date.prototype.format = function (a) {
			DateFormat.Init(a,this);
			return DateFormat.Get();
		};
	}
})();