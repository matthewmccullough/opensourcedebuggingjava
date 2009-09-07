import grails.converters.XML
import grails.converters.JSON
import javax.swing.text.html.HTML
import com.ambientideas.QueryHistory
import com.ambientideas.CarShow

class CarShowController {
  def scaffold = com.ambientideas.CarShow

  //GET
  def show = {
    def carShowInstance = CarShow.get( params.id )

    if(carShowInstance == null) {
      flash.message = "CarShow not found with id ${params.id}"
      redirect(action:list)
    }

    //INTENTIONAL BUG
    //Converters: http://docs.codehaus.org/display/GRAILS/Converters+Reference
    def converter = carShowInstance as XML
    String xmlBean = converter.toString()
    QueryHistory.addHistoryElement(xmlBean)

    withFormat {
      html {return [ carShowInstance : carShowInstance ]}
      json { render carShowInstance as JSON }
      xml { render carShowInstance as XML}
    }
  }
  
  //All the other controllers are scaffolded
}
