import { UserReview } from "./UserReview";
import { Image } from "./Image";

export class Place{
     placeId;
	 name;	
	 description;
	 avgRating;
	 pageViewCount;
	 noOfReviews;
	 reviews: [UserReview];
	 placeImages: [Image];
	 cityId;
	 placeCreationImageString;
}