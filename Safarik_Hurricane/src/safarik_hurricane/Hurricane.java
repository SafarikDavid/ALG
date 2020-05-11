package safarik_hurricane;

/**
 *
 * @author David
 */
public class Hurricane{
    private int year;
    private String month;
    private int pressure;
    private float speed;
    private String name;
    private int category;

    public Hurricane(int year, String month, int pressure, int knots, String name) {
        this.year = year;
        this.month = month;
        this.pressure = pressure;
        this.speed = convertKnotsToKm(knots);
        this.name = name;
        this.category = calculateSaffirSimpsonScale(this.speed);
    }
    
    /**
     * Converts knots/h to km/h
     * @param knots integer
     * @return knots/hour converted to (float) kilometers/hour
     */
    private static float convertKnotsToKm(int knots){
        return (float) (knots * 1.852);
    }
    
    /**
     * Determines the category on the Simpson hurricane scale by km/h
     * Five	≥ 70 m/s  	≥ 137 kn  	≥ 157 mph  	≥ 252 km/h  
     * Four	  58–70 m/s  	  113–136 kn  	  130–156 mph  	  209–251 km/h  
     * Three	  50–58 m/s  	  96–112 kn  	  111–129 mph  	  178–208 km/h  
     * Two	  43–49 m/s  	  83–95 kn  	  96–110 mph  	  154–177 km/h  
     * One	  33–42 m/s  	  64–82 kn  	  74–95 mph  	  119–153 km/h
     * @param speed in km/h, ceils input
     * @return 0 if not on scale, else 1 - 5 according to scale
     */
    private static int calculateSaffirSimpsonScale(float speed){
        speed = (float) Math.ceil(speed);
        if(speed >= 119 && 153 >= speed){
            return 1;
        }else if(speed >= 154 && 177 >= speed){
            return 2;
        }else if(speed >= 178 && 208 >= speed){
            return 3;
        }else if(speed >= 209 && 251 >= speed){
            return 4;
        }else if(speed >= 252){
            return 5;
        }else{
            return 0;
        }
    }

    public int getYear() {
        return year;
    }

    public float getSpeed() {
        return speed;
    }

    public int getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Hurricane{" + "year=" + year + ", month=" + month + ", pressure=" + pressure + ", speed=" + speed + ", name=" + name + ", saffirSimpsonScale=" + category + '}';
    }
    
    public static void main(String[] args){
        Hurricane h = new Hurricane(2000, "June", 1567, 27, "Katrina");
        System.out.println(h.toString());
    }

}
