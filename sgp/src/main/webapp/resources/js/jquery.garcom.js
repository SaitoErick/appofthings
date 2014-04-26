/** 
 * @see: https://github.com/loopj/jquery-tokeninput/blob/master/src/jquery.tokeninput.js
 * url to test: http://shell.loopj.com/tokeninput/tvshows.php
 */
 // @see: http://www.youtube.com/watch?v=FdJINb0breE parei no min 22

// TODO: study prototype

// Utility for browser not support "Object.create"
if (typeof Object.create !== 'function') {
    Object.create = function(obj) {
        function F() {};
        F.prototype = obj;
        return new F();
    }
}

(function($, undefined) {

    var Garcom = {
        init: function(options, element) {
            var self = this;
            self.element = element; // refers to DOM element selected
            self.$element = $(element); // refers to jquery object selected

            self.url = (typeof options === 'string')
                ? options
                : options.url;

            self.options = $.extend({}, $.fn.garcom.options, options);

            self.cycle();
        },

        fetch: function() {
            return $.ajax({
                url: this.url
                //data: {q: this.search} // TODO: checar se eh necessario
            });
        },

        suggest: function(suggestions) {
            this.$element.autocomplete({
                source: suggestions
            });
        },

        cycle: function() {
            var self = this;
            self.fetch().done(function(result) {
                // TODO: checar se vai ser preciso tratar o JSON aqui
                self.suggest(result);
            });
        }
    };

    $.fn.garcom = function(options) {
        return this.each(function() {
            var garcom = Object.create(Garcom);
            garcom.init(options, this);
        });
    };

    // to provide the most frexibiliti to users set default options here
    // out of $.fn.Garcom = function(url_or_data, options)
    // users can set theier own default values like this instead of replace
    $.fn.garcom.options = {

    };

}(jQuery));








        /*
        // default settings
        var settings = $.extend({
            method: 'GET',
            queryParam: 'q',
            searchDelay: 300,
            minChars: 1,
            jsonContainer: null,
            contentType: 'json',
            propertyToSearch: 'name',
            referenceKeyField: null,
            crossDomain: false
        }, options);

        return this.each( function() {

            var ajax_params = {};
            ajax_params.data = {};
            ajax_params.url = url_or_data;
            ajax_params.type = settings.method;
            ajax_params.dataType = settings.contentType;
            if (crossDomain)
                ajax_params.dataType = 'jsonp';

            $.ajax(ajax_params);

            //$(this).autocomplete({
            //  source: availableValues
            //});

        });*/