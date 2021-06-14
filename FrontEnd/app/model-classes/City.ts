import { Place } from "./Place";
import { Image } from "./Image";

export class City{
     cityId;
	 name;
	 description;
	 places: [Place];
	 cityImages: [Image];
	 cityCreationImageString;
}