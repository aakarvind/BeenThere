// Protractor configuration file, see link for more information
// https://github.com/angular/protractor/blob/master/lib/config.ts

const { SpecReporter } = require('jasmine-spec-reporter');

exports.config = {
  allScriptsTimeout: 11000,
  specs: [
    './e2e/**/*.e2e-spec.ts'
  ],
  capabilities: {
    'browserName': 'chrome'
  },
  directConnect: true,
  baseUrl: 'http://localhost:4200/',
  framework: 'jasmine',
  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 30000,
    print: function() {}
  },
  onPrepare() {
    require('ts-node').register({
      project: 'e2e/tsconfig.e2e.json'
    });
    jasmine.getEnv().addReporter(new SpecReporter({ spec: { displayStacktrace: true } }));
  }
};
$(document).ready(function() {
  $('#media').carousel({
    pause: true,
    interval: false,
  });
});



// -------ABOUT US CARD----------

$(function(){
  $('.list li:first-child').click(function(){
     window.setTimeout(function() {
         $('.profile').slideToggle();
              }, 300);
  });
  $('.list li:nth-child(2)').click(function(){
     window.setTimeout(function(){
    $('.trivia').slideToggle();
        },300);
  });
  $('.list li:nth-child(3)').click(function(){
     window.setTimeout(function(){
    $('.movies').slideToggle(); 
        },300);
  });
  $('.list li:nth-child(4)').click(function(){
     window.setTimeout(function(){
    $('.awards').slideToggle();
      }, 300);
  });
  $('.list li:nth-child(5)').click(function(){
     window.setTimeout(function(){
    $('.quotes').slideToggle();
      }, 300);
  });
  $('.btn-close').click(function(){
    $('.list-content').hide(300);
  });
});


// *****************************

