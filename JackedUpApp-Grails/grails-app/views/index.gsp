<html>
    <head>
        <title>Welcome to JackedUp!</title>
        <meta name="layout" content="main" />
    </head>
    <body>
        <h1 style="margin-left:20px;">Welcome to the JackedUp App!</h1>
        <br/>
        <p style="margin-left:20px;width:80%">The central ticket and event clearinghouse
          for Monster Truck events, world-wide.</p>
        <br/>
        
        <h2 style="margin-left:20px;margin-bottom:50px;width:80%">
          <a href="carShow">Start here by viewing the list of upcoming car shows.</a>
        </h2>
        
        <div class="dialog" style="margin-left:20px;width:60%;">
            <p>Dynamic list of controllers:</p>
            <ul>
              <g:each var="c" in="${grailsApplication.controllerClasses}">
                    <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
              </g:each>
            </ul>
        </div>
    </body>
</html>