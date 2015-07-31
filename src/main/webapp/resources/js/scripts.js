$(document).ready(function () {
    'use strict';

    $('#search-input').prop('disabled', true);
    $('#search-input').popover({content: "To search just type de room name, location or floor!", placement: "top"}).blur(function () {
            $(this).popover('hide');
        });
    $('.fa-thumbs-up').tooltip({title: "Room Available", placement: "top", container: 'body'});

    var aotAPI = "http://appofthings.appspot.com/status?callback=?";
    $.getJSON(aotAPI, {
        format: "json"
    })
        .done(function(data) {
            addHtml(data);
        });
});

function addHtml(data) {
    $('#accordion').empty();
    var lessThanThree = false;

    if (data.length < 3) {
        lessThanThree = true;
    };

    $.each(data, function(index, value) {
        index++;

        //definição do icone de sinalização da sala
        var iconClass = "fa fa-thumbs-up";
        if (value.busy) {
            iconClass = "fa fa-thumbs-down";
        };

        // Collapsable
        var collapsableHtml = $.parseHTML('<div class="room-panel panel panel-default"><div class="panel-heading"><h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#' + index + '">' + value.local.room + ' - ' + value.busy + '</a></h4></div><div id="' + index + '" class="panel-collapse collapse in"><div class="panel-body"><b>Location:</b> ' + value.local.base + '<br /><b>Building:</b> ' + value.local.building + '<br /><b>Floor:</b> ' + value.local.floor + '<br /></div><div id="search-string-' + index + '" style="display: none;">' + value.arduinoName + value.busy + value.local.base + value.local.building + value.local.floor + value.local.room  + '</div></div></div>');
        //Not Collapsable
        var collapsableHtml = $.parseHTML('<div class="room-panel panel panel-primary"><div class="panel-heading"><h3 class="panel-title">' + value.local.room + ' <span class="' + iconClass + '"></span></h3></div><div class="panel-body"><b>Location:</b> ' + value.local.base + '<br /><b>Building:</b> ' + value.local.building + '<br /><b>Floor:</b> ' + value.local.floor + '<br /></div><div id="search-string-' + index + '" style="display: none;">' + value.arduinoName + value.busy + value.local.base + value.local.building + value.local.floor + value.local.room  + '</div></div></div>');
        $('#accordion').append(collapsableHtml);
    });

    $('#search-input').prop('disabled', false);
}

$('#search-input').keyup(function() {
    search($('#search-input').val());
});

function search(queryString) {
    var searchTerms = queryString.split(' ');
    searchTerms = removeEmptyStringsFromArray(searchTerms);
    if (searchTerms.length <= 0) {
        searchTerms.push("");
    };
    console.log(searchTerms);

    var results = new Array();
    var rooms = new Array();
    rooms = getRooms();
    for (var i = 0; i < searchTerms.length; i++) {
        for (var j = 0; j < rooms.length; j++) {
            if (rooms[j].text.indexOf(searchTerms[i]) > -1) {
                results.push(rooms[j].element);
            }
        }
    }

    $('.room-panel').each(function(index, element) {
        $(this).css('display', 'none');
    });

    for (var k = 0; k < results.length; k++) {
        $(results[k]).css('display', 'block');
    }
}

function getRooms() {
    var rooms = new Array();
    $('.room-panel').each(function(index, element) {
        index++;
        rooms.push({
            text: $('#search-string-' + index).text(),
            element: element
        });
    });

    return rooms;
}

function removeEmptyStringsFromArray(array) {
    var newArray = new Array();
    for(var i = 0; i < array.length; i++) {
        if (array[i]) {
            newArray.push(array[i]);
        }
    }

    return newArray;
}
