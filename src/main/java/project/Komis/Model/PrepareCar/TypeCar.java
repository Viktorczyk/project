package project.Komis.Model.PrepareCar;

public enum TypeCar {

     OSOBOWE, CIĘŻAROWE ;

     public static TypeCar checkTypeCar(Integer typeCarId){
         switch (typeCarId){

             case 1: return TypeCar.OSOBOWE;
             case 2: return TypeCar.CIĘŻAROWE;

         }

         return null;
     }



}
