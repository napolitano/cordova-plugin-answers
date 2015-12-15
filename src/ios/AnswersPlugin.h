//
//  AnswersPlugin.h
//
//  Axel Napolitano, Napolitano Business Solutions - 2015/12/15
//

#import "AnswersPlugin"
#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>

@interface AnswersPlugin : CDVPlugin <UIAlertViewDelegate>

    - (void)sendSignUp:(CDVInvokedUrlCommand*)command;
    - (void)sendLogIn:(CDVInvokedUrlCommand*)command;
    - (void)sendContentView:(CDVInvokedUrlCommand*)command;
    - (void)sendCustomEvent:(CDVInvokedUrlCommand*)command;

@end