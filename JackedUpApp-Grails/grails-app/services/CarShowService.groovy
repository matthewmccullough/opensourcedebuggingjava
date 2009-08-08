//import javax.jws.WebParam

class CarShowService {
  static expose=['xfire']
  boolean transactional = true

  CarShow getCarShow(int id){
    return CarShow.get(id)
  }
  
  boolean isValidCarShow(int id){
    return (CarShow.get(id) != null)
  }
  
  
  List<CarShow> getAllCarShows(){
    return CarShow.list()
  }
  
  CarShow[] getAllCarShowsAsArray(){
    CarShow.list() as CarShow[]
  }

  //Can get fancy with naming the input parameters, specifying that they are in the header
  /*CarShow otherServiceMethod(@WebParam(name="token", header=true)UserToken token, CarShow obj) {
      // do something here
  }*/
}
