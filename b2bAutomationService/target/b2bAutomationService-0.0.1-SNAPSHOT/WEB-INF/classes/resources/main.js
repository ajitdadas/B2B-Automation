(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./src/$$_lazy_route_resource lazy recursive":
/*!**********************************************************!*\
  !*** ./src/$$_lazy_route_resource lazy namespace object ***!
  \**********************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2FwcC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/app.component.html":
/*!************************************!*\
  !*** ./src/app/app.component.html ***!
  \************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<html>\n<head>\n<style>\n   html{\n    margin-left: -8px;\n    margin-top: -8px;\n    margin-bottom: 4px;\n    vertical-align: top;\n    width: 101%;\n    height: 781px;\n    background-image: url(\"../assets/Background.jpg\");\n    background-position: bottom;\n    \n}\n</style>\n</head>\n<body>\n  <table style=\"width: 100%;\">\n    <tr>\n      <td style=\"width: 100%;font-family: sans-serif;font-size: 50px;color: azure;\n      vertical-align: center; text-align: center;height: 100px;\" colspan=\"5\">\n      B2B UTILITY\n      </td>\n    </tr>\n    <tr>\n<td style=\"height: 100px;\" colspan=\"5\">\n\n  </td>\n      </tr>\n      <tr style=\"height: 70px;color:lightsteelblue\">\n          <td style=\"font-size: 80px;\">\n              \n           </td>\n          <td style=\"font-size: 20px;\">\n            <b> Track Details :</b>\n          </td>\n          <td style=\"font-size: 20px;\">\n            <b> Application Name :</b>\n          </td>\n          <td style=\"font-size: 20px;\">\n            <b> Service :</b>\n          </td>\n           <td style=\"font-size: 20px;\">\n            <b>  Test Scenarios :</b>\n          </td>\n          </tr>\n      <tr>\n          <td style=\"width: 10%;\">\n           \n           </td>\n        <td style=\"width: 25%;\">\n            <select (input)=\"fillTrackName($event)\">\n              <option *ngFor=\"let track of tracks\" >{{track}}</option>\n            </select>\n        </td>\n        <td style=\"width: 25%\">\n            <select (input)=\"fillApplicationName($event)\">\n                <option *ngFor=\"let application of applications\">{{application}}</option>\n              </select>\n        </td>\n        <td style=\"width: 25%\">\n            <select (input)=\"fillServiceName($event)\">\n               <option *ngFor=\"let service of services\">{{service}}</option>\n              </select>\n        </td>\n        <td style=\"width: 25%;text-align: left;\">\n           <select>\n                <option value=\"volvo\">File 1</option>\n                <option value=\"saab\">File 2</option>\n                <option value=\"opel\">File 3</option>\n                <option value=\"audi\">File 4</option>\n            </select>\n            <a href=\"\" style=\"color:rgb(206, 206, 206);font-family: serif;font-weight: bold;padding-left: 10px;\">Upload</a>\n          </td>\n        </tr>\n        <tr>\n            <td style=\"width: 100%;font-family: sans-serif;font-size: 50px;color: azure;\n            vertical-align: center; text-align: center;height: 400px;\" colspan=\"5\">\n            <button type=\"submit\" form=\"form1\" class=\"btn-outline-dark\" value=\"Submit\" (click)=\"getDataFromMongo()\">Submit</button>\n            </td>\n          </tr>\n    </table>\n\n</body>\n</html>"

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'download.jpg';
        this.tracks = ['(None)', 'B2B', 'Order', 'Notifications', 'Quoting'];
        this.applications = ['(None)', 'NGC', 'NGOO', 'PUNCHOUT', 'EWS', 'QWS'];
        this.services = ['(None)', 'VCS', 'Preview BTO', 'Cisco ONE', 'Config Recommendation'];
        this.track = '';
        this.application = '';
        this.service = '';
    }
    AppComponent.prototype.fillTrackName = function (event) {
        this.service = event.target.value;
    };
    AppComponent.prototype.fillApplicationName = function (event) {
        this.service = event.target.value;
    };
    AppComponent.prototype.fillServiceName = function (event) {
        this.service = event.target.value;
    };
    AppComponent.prototype.getDataFromMongo = function () {
    };
    AppComponent.prototype.ngOnInit = function () { };
    AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-root',
            template: __webpack_require__(/*! ./app.component.html */ "./src/app/app.component.html"),
            styles: [__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm5/platform-browser.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm5/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm5/http.js");
/* harmony import */ var _filerecord_filerecord_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./filerecord/filerecord.component */ "./src/app/filerecord/filerecord.component.ts");







var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["NgModule"])({
            declarations: [
                _app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"],
                _filerecord_filerecord_component__WEBPACK_IMPORTED_MODULE_6__["FilerecordComponent"]
            ],
            imports: [
                _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                _angular_forms__WEBPACK_IMPORTED_MODULE_4__["FormsModule"],
                _angular_common_http__WEBPACK_IMPORTED_MODULE_5__["HttpClientModule"]
            ],
            providers: [],
            bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_3__["AppComponent"]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "./src/app/filerecord/filerecord.component.css":
/*!*****************************************************!*\
  !*** ./src/app/filerecord/filerecord.component.css ***!
  \*****************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL2ZpbGVyZWNvcmQvZmlsZXJlY29yZC5jb21wb25lbnQuY3NzIn0= */"

/***/ }),

/***/ "./src/app/filerecord/filerecord.component.html":
/*!******************************************************!*\
  !*** ./src/app/filerecord/filerecord.component.html ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

module.exports = "<p>\n  filerecord works!\n</p>\n"

/***/ }),

/***/ "./src/app/filerecord/filerecord.component.ts":
/*!****************************************************!*\
  !*** ./src/app/filerecord/filerecord.component.ts ***!
  \****************************************************/
/*! exports provided: FilerecordComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilerecordComponent", function() { return FilerecordComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");


var FilerecordComponent = /** @class */ (function () {
    function FilerecordComponent() {
    }
    FilerecordComponent.prototype.ngOnInit = function () {
    };
    FilerecordComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
        Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
            selector: 'app-filerecord',
            template: __webpack_require__(/*! ./filerecord.component.html */ "./src/app/filerecord/filerecord.component.html"),
            styles: [__webpack_require__(/*! ./filerecord.component.css */ "./src/app/filerecord/filerecord.component.css")]
        }),
        tslib__WEBPACK_IMPORTED_MODULE_0__["__metadata"]("design:paramtypes", [])
    ], FilerecordComponent);
    return FilerecordComponent;
}());



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.
var environment = {
    production: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm5/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm5/platform-browser-dynamic.js");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_3__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_1__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"])
    .catch(function (err) { return console.error(err); });


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Users\avratnaw\Documents\API Automation\b2bAutomationParent\b2bAutomationWeb\src\main\web\my-app\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main.js.map