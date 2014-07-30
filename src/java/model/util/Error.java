/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.util;

/**
 *
 * @author miguel
 */
 public class Error{
        private String type;
        private String description;
        
        public Error(){
        }
        
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        
        public void setTypeAndDescription(String t,String d){
            this.type=t;
            this.description=d;            
        }
    }
    