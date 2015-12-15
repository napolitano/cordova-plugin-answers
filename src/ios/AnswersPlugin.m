//
//  AnswersPlugin.m
//
//  Axel Napolitano, Napolitano Business Solutions - 2015/12/15
//

#import <Fabric/Fabric.h>
#import <Crashlytics/Answers.h>

@implementation AnswersPlugin

    -(void) sendSignUp:(CDVInvokedUrlCommand *)command {
        [self.commandDelegate runInBackground:^{
            [Answers logSignUpWithMethod:@"Direct" success:@YES customAttributes:@{}];
        }];
    }

    -(void) sendLogIn:(CDVInvokedUrlCommand *)command {
        [self.commandDelegate runInBackground:^{
            [Answers logLoginWithMethod:@"Direct" success:@YES customAttributes:@{}];
        }];
    }

    -(void) sendContentView:(CDVInvokedUrlCommand *)command {
        NSMutableDictionary *obj = [command argumentAtIndex:0];

        NSString *name = [obj valueForKey:@"name"];
        NSString *type = [obj valueForKey:@"type"];
        NSString *_id = [obj valueForKey:@"id"];

        NSDictionary *attributes = [obj objectForKey:@"attributes"];

        [self.commandDelegate runInBackground:^{
            [Answers logContentViewWithName:name contentType:type contentId:_id customAttributes:attributes];
        }];
    }

    -(void) sendCustomEvent:(CDVInvokedUrlCommand *)command {
        NSMutableDictionary *obj = [command argumentAtIndex:0];

        NSString *name = [obj valueForKey:@"name"];

        NSDictionary *attributes = [obj objectForKey:@"attributes"];

        [self.commandDelegate runInBackground:^{
            [Answers logCustomEventWithName:name customAttributes:attributes];
        }];
    }

@end
