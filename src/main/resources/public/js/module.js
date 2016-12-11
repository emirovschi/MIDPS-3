var app = angular.module('App', ['ngMaterial', 'ngMessages', 'ngAnimate', 'ngRoute'])
.config(function($mdThemingProvider) {
    $mdThemingProvider.theme('default')
      .primaryPalette('light-blue');

    $mdThemingProvider.theme('login')
      .primaryPalette('light-blue',{
        'default': '100'
      })
      .warnPalette('pink')
      .backgroundPalette('light-blue',{
        'default': '100'
      })
      .dark();

    $mdThemingProvider.theme('info')
      .primaryPalette('light-blue')
      .backgroundPalette('light-blue');

    $mdThemingProvider.theme('success')
      .primaryPalette('green')
      .backgroundPalette('green');

    $mdThemingProvider.theme('error')
      .primaryPalette('deep-orange')
      .backgroundPalette('deep-orange');
  });