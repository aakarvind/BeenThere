import { User } from "./User";
import { Place } from "./Place";

export class AdminDashBoardData{
     trendingPlace: [Place];
	 topSearchedPlaces: [Place];
	 topContactedUsers: [User];
	 topTravellingUsers: [User];
	 satisfactionLevel: number;
	 helpdeskStatus: number;
	 userNamesForSearch: [string];
	 errorMessage: string;
}