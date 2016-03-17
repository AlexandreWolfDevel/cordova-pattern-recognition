
module.exports = {
    locate: function (name, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "PatternRecognition", "locate", [name]);
    }
};
