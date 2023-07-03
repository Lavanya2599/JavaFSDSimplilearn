/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./src/js/main.js":
/*!************************!*\
  !*** ./src/js/main.js ***!
  \************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _team__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./team */ \"./src/js/team.js\");\n\r\n\r\n// Sample team members\r\nconst team = [\r\n  new _team__WEBPACK_IMPORTED_MODULE_0__.TeamMember(\"John Doe\", \"Developer\", 50000),\r\n  new _team__WEBPACK_IMPORTED_MODULE_0__.TeamMember(\"Jane Smith\", \"Designer\", 60000),\r\n  new _team__WEBPACK_IMPORTED_MODULE_0__.TeamMember(\"Mike Johnson\", \"Tester\", 45000)\r\n];\r\n\r\n// Display team members\r\nconst teamList = document.getElementById('team-list');\r\nteam.forEach(member => {\r\n  const listItem = document.createElement('li');\r\n  listItem.textContent = `${member.name} - ${member.role}`;\r\n  teamList.appendChild(listItem);\r\n});\r\n\r\n// Calculate and display the total budget\r\nconst totalBudget = (0,_team__WEBPACK_IMPORTED_MODULE_0__.calculateTeamBudget)(team);\r\nconst totalBudgetElement = document.getElementById('total-budget');\r\ntotalBudgetElement.textContent = `Total Budget: $${totalBudget}`;\r\n\n\n//# sourceURL=webpack://team-budget-planner/./src/js/main.js?");

/***/ }),

/***/ "./src/js/team.js":
/*!************************!*\
  !*** ./src/js/team.js ***!
  \************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   TeamMember: () => (/* binding */ TeamMember),\n/* harmony export */   calculateTeamBudget: () => (/* binding */ calculateTeamBudget)\n/* harmony export */ });\nfunction TeamMember(name, role, salary) {\r\n    this.name = name;\r\n    this.role = role;\r\n    this.salary = salary;\r\n  }\r\n  \r\n  function calculateTeamBudget(team) {\r\n    let totalBudget = 0;\r\n    for (let i = 0; i < team.length; i++) {\r\n      totalBudget += team[i].salary;\r\n    }\r\n    return totalBudget;\r\n  }\r\n  \n\n//# sourceURL=webpack://team-budget-planner/./src/js/team.js?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	/* webpack/runtime/define property getters */
/******/ 	(() => {
/******/ 		// define getter functions for harmony exports
/******/ 		__webpack_require__.d = (exports, definition) => {
/******/ 			for(var key in definition) {
/******/ 				if(__webpack_require__.o(definition, key) && !__webpack_require__.o(exports, key)) {
/******/ 					Object.defineProperty(exports, key, { enumerable: true, get: definition[key] });
/******/ 				}
/******/ 			}
/******/ 		};
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/hasOwnProperty shorthand */
/******/ 	(() => {
/******/ 		__webpack_require__.o = (obj, prop) => (Object.prototype.hasOwnProperty.call(obj, prop))
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/make namespace object */
/******/ 	(() => {
/******/ 		// define __esModule on exports
/******/ 		__webpack_require__.r = (exports) => {
/******/ 			if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 				Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 			}
/******/ 			Object.defineProperty(exports, '__esModule', { value: true });
/******/ 		};
/******/ 	})();
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = __webpack_require__("./src/js/main.js");
/******/ 	
/******/ })()
;