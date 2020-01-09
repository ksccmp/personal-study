webpackHotUpdate("static\\development\\pages\\signup.js",{

/***/ "./pages/signup.js":
/*!*************************!*\
  !*** ./pages/signup.js ***!
  \*************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! react */ "./node_modules/react/index.js");
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(react__WEBPACK_IMPORTED_MODULE_0__);
/* harmony import */ var antd__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! antd */ "./node_modules/antd/es/index.js");
/* harmony import */ var prop_types__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! prop-types */ "./node_modules/prop-types/index.js?d7bc");
/* harmony import */ var prop_types__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(prop_types__WEBPACK_IMPORTED_MODULE_2__);
var _jsxFileName = "C:\\Users\\multicampus\\Desktop\\SC_2\\personal-study\\frontend\\react\\nodebird-tutorial\\ch1\\front\\pages\\signup.js";
var __jsx = react__WEBPACK_IMPORTED_MODULE_0___default.a.createElement;


 // 타이핑 칠 때마다 최적화 해주는 방법 (페이스북도 사용 잘 안함)
// const TextInput = memo(({value, onChange}) => {
//     return (
//         <Input name="user-id" value={value} required onChange={onChange}></Input>
//     );
// });

var TextInput = function TextInput(_ref) {
  var value = _ref.value;
  return __jsx("div", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 14
    },
    __self: this
  }, value);
};

TextInput.propTypes = {
  value: prop_types__WEBPACK_IMPORTED_MODULE_2___default.a.string
};

var Signup = function Signup() {
  var _useState = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(''),
      id = _useState[0],
      setId = _useState[1];

  var _useState2 = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(''),
      nick = _useState2[0],
      setNick = _useState2[1];

  var _useState3 = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(''),
      password = _useState3[0],
      setPassword = _useState3[1];

  var _useState4 = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(''),
      passwordCheck = _useState4[0],
      setPasswordCheck = _useState4[1];

  var _useState5 = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(false),
      term = _useState5[0],
      setTerm = _useState5[1];

  var _useState6 = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(false),
      passwordError = _useState6[0],
      setPasswordError = _useState6[1];

  var _useState7 = Object(react__WEBPACK_IMPORTED_MODULE_0__["useState"])(false),
      termError = _useState7[0],
      setTermError = _useState7[1];

  var onSubmit = Object(react__WEBPACK_IMPORTED_MODULE_0__["useCallback"])(function (e) {
    e.preventDefault();

    if (password !== passwordCheck) {
      return setPasswordError(true);
    }

    if (!term) {
      return setTermError(true);
    }
  }, [password, passwordCheck, term]);

  var onChangeId = function onChangeId(e) {
    setId(e.target.value);
  };

  var onChangeNick = function onChangeNick(e) {
    setNick(e.target.value);
  };

  var onChangePassword = function onChangePassword(e) {
    setPassword(e.target.value);
  };

  var onChangePasswordChk = Object(react__WEBPACK_IMPORTED_MODULE_0__["useCallback"])(function (e) {
    setPasswordError(e.target.value !== password);
    setPasswordCheck(e.target.value);
  }, [password]);
  var onChangeTerm = Object(react__WEBPACK_IMPORTED_MODULE_0__["useCallback"])(function (e) {
    setTermError(false);
    setTerm(e.target.checked);
  }, []); // 커스텀 훅 (반복을 제거 가능)
  // const useInput = (initValue = null) => {
  //     const [value, setter] = useState(initValue);
  //     const handler = (e) => {
  //         setter(e.target.value);
  //     };
  //     return [value, handler];
  // };
  // const [id, onChangeId] = useInput('');

  return __jsx(react__WEBPACK_IMPORTED_MODULE_0___default.a.Fragment, null, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Form"], {
    onSubmit: onSubmit,
    style: {
      padding: 10
    },
    __source: {
      fileName: _jsxFileName,
      lineNumber: 71
    },
    __self: this
  }, __jsx(TextInput, {
    value: "135135",
    __source: {
      fileName: _jsxFileName,
      lineNumber: 72
    },
    __self: this
  }), __jsx("div", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 73
    },
    __self: this
  }, __jsx("label", {
    htmlFor: "user-id",
    __source: {
      fileName: _jsxFileName,
      lineNumber: 74
    },
    __self: this
  }, "\uC544\uC774\uB514"), __jsx("br", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 75
    },
    __self: this
  }), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"], {
    name: "user-id",
    value: id,
    required: true,
    onChange: onChangeId,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 76
    },
    __self: this
  })), __jsx("div", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 79
    },
    __self: this
  }, __jsx("label", {
    htmlFor: "user-nick",
    __source: {
      fileName: _jsxFileName,
      lineNumber: 80
    },
    __self: this
  }, "\uB2C9\uB124\uC784"), __jsx("br", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 81
    },
    __self: this
  }), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"], {
    name: "user-nick",
    value: nick,
    required: true,
    onChange: onChangeNick,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 82
    },
    __self: this
  })), __jsx("div", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 84
    },
    __self: this
  }, __jsx("label", {
    htmlFor: "user-password",
    __source: {
      fileName: _jsxFileName,
      lineNumber: 85
    },
    __self: this
  }, "\uBE44\uBC00\uBC88\uD638"), __jsx("br", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 86
    },
    __self: this
  }), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"], {
    name: "user-password",
    type: "password",
    value: password,
    required: true,
    onChange: onChangePassword,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 87
    },
    __self: this
  })), __jsx("div", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 89
    },
    __self: this
  }, __jsx("label", {
    htmlFor: "user-password-check",
    __source: {
      fileName: _jsxFileName,
      lineNumber: 90
    },
    __self: this
  }, "\uBE44\uBC00\uBC88\uD638\uCCB4\uD06C"), __jsx("br", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 91
    },
    __self: this
  }), __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Input"], {
    name: "user-password-check",
    type: "password",
    value: passwordCheck,
    required: true,
    onChange: onChangePasswordChk,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 92
    },
    __self: this
  }), passwordError && __jsx("div", {
    style: {
      color: 'red'
    },
    __source: {
      fileName: _jsxFileName,
      lineNumber: 93
    },
    __self: this
  }, " \uBE44\uBC00\uBC88\uD638\uAC00 \uC77C\uCE58\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.")), __jsx("div", {
    __source: {
      fileName: _jsxFileName,
      lineNumber: 95
    },
    __self: this
  }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Checkbox"], {
    name: "user-term",
    value: term,
    onChange: onChangeTerm,
    __source: {
      fileName: _jsxFileName,
      lineNumber: 96
    },
    __self: this
  }, "\uC81C\uB85C\uCD08 \uB9D0\uC744 \uC798 \uB4E4\uC744 \uAC83\uC744 \uB3D9\uC758\uD569\uB2C8\uB2E4."), termError && __jsx("div", {
    style: {
      color: 'red'
    },
    __source: {
      fileName: _jsxFileName,
      lineNumber: 97
    },
    __self: this
  }, " \uC57D\uAD00\uC5D0 \uB3D9\uC758\uD558\uC154\uC57C \uD569\uB2C8\uB2E4.")), __jsx("div", {
    style: {
      marginTop: 10
    },
    __source: {
      fileName: _jsxFileName,
      lineNumber: 99
    },
    __self: this
  }, __jsx(antd__WEBPACK_IMPORTED_MODULE_1__["Button"], {
    type: "primary",
    htmlType: "submit",
    __source: {
      fileName: _jsxFileName,
      lineNumber: 100
    },
    __self: this
  }, "\uAC00\uC785\uD558\uAE30"))));
};

/* harmony default export */ __webpack_exports__["default"] = (Signup);

/***/ })

})
//# sourceMappingURL=signup.js.093888a4ac78c3937a22.hot-update.js.map