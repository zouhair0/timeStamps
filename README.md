[EN]

# Timestamps in Java

The goal of the project is to build a gradle application displaying a difference between two timestamps. It reads Stdin line by line, each line containing two ISO-8601 date and time, separated with a space. Then, it
produces the time difference, human readable to Stdout. An error on a given line is shown in Stderr
and the application must continue with the next line.

A negative or zero difference is an error and must be reported as is.

We remove the "leading 0" so if there are 0 days, or 0 days and 0 hours, we will not display them

The human readable output format is a single line, with the duration expressed as day(s), hour(s),
minute(s) and second(s) where 
* 1 day = 24 hours
* 1 hour = 60 minutes
* 1 minute = 60 seconds

Each part is separated by `, `

## Examples

```
> 2020-04-20T06:05:30Z 2020-04-21T08:05:31Z 
1 day, 2 hours, 0 minutes, 1 second
```

```
> 2020-04-20T06:05:30Z 2020-04-20T06:06:33Z
1 minute, 3 seconds
```

## Run / Build
- Import the project in Eclipse / Intellij
- Run App.java as a Java application
- Launch './gradlew build' to build the project and generate a jar with embedded dependencies
- Then you can run the application from the command line : java -jar timestamps-demo.jar
