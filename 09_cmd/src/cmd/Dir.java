/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author David Šafařík
 */
public class Dir extends Command{

    @Override
    public String execute(File actualDir) {
        File[] files;
        if(params.length == 1){
            files = actualDir.listFiles();
            return dirToString(files);
        }else if(params.length == 2){
            if(params[1].contains("-o")){
                files = actualDir.listFiles();
                return order(files);
            }
        }else if(params.length == 3){
            if(params[1].contains("-e")){
                files = actualDir.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(params[2]);
                    }
                });
            return dirToString(files);
//                files = actualDir.listFiles(); //zkusit přes FileNameFilter stejný princip jako Comparator
//                return specifiedExtension(files, params[2]);
            }else if(params[1].contains("-s")){
                files = actualDir.listFiles();
                return biggerThanSpecifiedSize(files, params[2]);
            }
        }
        return null;
    }
    
    private String dirToString(File[] files){
        StringBuilder sb = new StringBuilder("");
        for(File file : files){
            if(file.isDirectory()){
                sb.append(String.format("%s%n", file.getName()));
            }else{
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }
    
    private String order(File[] files){
        Arrays.sort(files);
        return dirToString(files);
    }
    
    private String specifiedExtension(File[] files, String extension){
        StringBuilder sb = new StringBuilder("");
        for(File file : files){
            if(file.getName().endsWith(extension)){
                if(file.isDirectory()){
                    sb.append(String.format("%s%n", file.getName()));
                }else{
                    sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                    sb.append(new Date(file.lastModified())).append("\n");
                }
            }
        }
        return sb.toString();
    }
    
    private String biggerThanSpecifiedSize(File[] files, String sizeString){
        long size = Long.parseLong(sizeString);
        StringBuilder sb = new StringBuilder("");
        for(File file : files){
            if(file.getTotalSpace() > size){
                if(file.isDirectory()){
                    sb.append(String.format("%s%n", file.getName()));
                }else{
                    sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                    sb.append(new Date(file.lastModified())).append("\n");
                }
            }
        }
        return sb.toString();
    }
    
}
