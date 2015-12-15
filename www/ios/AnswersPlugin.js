var exec = require('cordova/exec');

function AnswersPlugin() {
    'use strict';

    this._callback;
}

AnswersPlugin.prototype.sendSignUp = function() {
    'use strict';

    cordova.exec(null,
        null,
        "AnswersPlugin",
        "sendSignUp",
        null);
};

AnswersPlugin.prototype.sendLogIn = function() {
    'use strict';

    cordova.exec(null,
        null,
        "AnswersPlugin",
        "sendLogIn",
        null);
};

AnswersPlugin.prototype.sendContentView = function(name, type, id, attributes) {
    'use strict';

    var defaults = {
        name: name,
        type: type,
        id: id,
        attributes: attributes
    };

    cordova.exec(null,
        null,
        "AnswersPlugin",
        "sendContentView",
        [defaults]);
};

AnswersPlugin.prototype.sendCustomEvent = function(name, attributes) {
    'use strict';

    var defaults = {
        name: name,
        attributes: attributes
    };

    cordova.exec(null,
        null,
        "AnswersPlugin",
        "sendCustomEvent",
        [defaults]);
};

var answersPluginInstance = new AnswersPlugin();
module.exports = answersPluginInstance;

// Make plugin work under window.plugins
if (!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.answersPluginInstance) {
    window.plugins.answersPluginInstance = answersPluginInstance;
}