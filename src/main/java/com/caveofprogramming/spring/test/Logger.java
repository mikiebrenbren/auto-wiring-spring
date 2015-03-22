package com.caveofprogramming.spring.test;

/*
 * Dummy implementation of logger.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;

/*
    autowire, inject, and resource are all basically the same thing.  Use qualifier annotation to make annotations less ambiguous
    annotations can be used for member variables, methods, or contructors
 */

@Component
public class Logger {

//    @Autowired
//    @Inject  With inject use @Named annotation with a value to further remove ambiguity
//    @Resource
	private ConsoleWriter consoleWriter;
//    @Autowired
	private LogWriter fileWriter;

    @Autowired(required = false)
//    @Qualifier(value = "toConsole")
//    @Inject
    public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

    @Autowired 
//    @Qualifier("filewriter") //qualifier found in the LogWriter to remove ambiguity
//    @Inject
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
        if(consoleWriter != null) {
            consoleWriter.write(text);
        }
	}

    @PostConstruct
    public void init(){
        System.out.println("init");
    }

    @PreDestroy //must be a singleton to use this annotation
    public void destroy(){
        System.out.println("destroy");
    }

}
