class UrlMappings {
    static mappings = {
        
        //************************ REST **********************
        //If you map the list action to a non-unique name, you get a reverse mapping error
        // if you use content type handling to resolve XML and HTML responses.
        // The error is throw by the <g:sortableColumn .../> tag
        // http://jira.codehaus.org/browse/GRAILS-3080
        //
        //Also note that you should make this method distinguished from the resource (SAVE, UPDATE, DELETE, GET)
        // or you'll end up with resource collisions, even if you don't have a trailing slash on the
        // URL you try to call this by.  As an alternative, we are pluralizing this.
        "/rest/carShows"(controller:"carShowREST"){
            action = [GET:"list"]
        }
        
        //The content type routing is too annoying to fully map to the HTML
        // methods so just route it to 
        "/rest/carShow/$id?"(resource:"carShowREST")
        
        //Old school (pre-grails-1.1) mapping. Note that parse request has to be
        // set to true in Grails 1.1 to enable XML and JSON parsing.
         /*
        "/rest/show/$id"(controller:"product", parseRequest:true){
            action = [GET:"show", PUT:"update", DELETE:"delete", POST:"save"]
        }
        */
        
        //****************** DEFAULT MAPPINGS *******************
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
