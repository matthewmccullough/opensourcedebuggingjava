class BootStrap {

     def init = { servletContext ->
       new CarShow(city:"Boston", state: "MA", venue: "BigDigDome", minimumCompetitors: 7).save()
       new CarShow(city:"Albuquerque", state: "NM", venue: "DustDome", minimumCompetitors: 5).save()
     }
     def destroy = {
     }
} 