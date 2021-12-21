package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int raccoonsPlayingInWoods = 3;
		int raccoonsGoingToDinner = 2;
		int raccoonsLeftInWoods = raccoonsPlayingInWoods - raccoonsGoingToDinner;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int beesLessFlowers = flowers - bees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int lonelyPigeonEatingBreadcrumbs = 1;
		int anotherPigeon = 1;
		int bothPigeon = lonelyPigeonEatingBreadcrumbs + anotherPigeon;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int owlsSittingOnFence = 3;
		int additionalOwlsJoined = 2;
		int owlsOnFence = owlsSittingOnFence + additionalOwlsJoined;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int beaversWorkingOnHome = 2;
		int beaverWentSwimming = 1;
		int beaversStillWorkingOnHome = beaversWorkingOnHome - beaverWentSwimming;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int toucansSittingOnTreeLimb = 2;
		int toucansJoined = 1;
		int totalToucansSittingOnTreeLimb = toucansSittingOnTreeLimb + toucansJoined;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrelsInTree = 4;
		int squirrelsWithNuts = 2;
		int squirrelLessNuts = squirrelsInTree - squirrelsWithNuts;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		double quarterFound = 0.25;
		double dimeFound = 0.10;
		double nickelsFound = 0.10;
		double moneyFound = quarterFound + dimeFound + nickelsFound;

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int mrsBrierMuffinsBaked = 18;
		int mrsMacAdamsMuffinsBaked = 20;
		int mrsFlanneryMuffinsBaked = 17;
		int firstGradeMuffinsBaked = mrsBrierMuffinsBaked + mrsMacAdamsMuffinsBaked + mrsFlanneryMuffinsBaked;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		double priceOfYoyo = 0.24;
		double priceOfWhistle = 0.14;
		double priceSpentOnToys = priceOfYoyo + priceOfWhistle;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallowsUsed = 8;
		int miniMarshmallowsUsed = 10;
		int totalAmountOfMarshmallowsUsed = largeMarshmallowsUsed + miniMarshmallowsUsed;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int inchesOfSnowAtMrsHilts = 29;
		int inchesOfSnowAtBrecknockElementarySchool = 17;
		int differenceInInchesOfSnow = inchesOfSnowAtMrsHilts - inchesOfSnowAtBrecknockElementarySchool;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		double moneyOwned = 10.0;
		double moneySpentOnToyTruck = 3.0;
		double moneySpendOnPencil = 2.0;
		double moneyRemaining = moneyOwned - moneySpendOnPencil - moneySpentOnToyTruck;

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int marblesInCollection = 16;
		int marblesLost = 7;
		int marblesRemaining = marblesInCollection - marblesLost;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int seashellsOwned = 19;
		int seashellsInCollection = 25;
		int seashellsNeeded = seashellsInCollection - seashellsOwned;

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int booksOnShelf = 38;
		int booksAddedToShelf = 10;
		int totalBooksOnShelf = booksOnShelf + booksAddedToShelf;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int legsOnBees = 6;
		int legsOnEightBees = legsOnBees * 8;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double costOfIceCream = 0.99;
		double costOfTwoIceCream = 0.99 * 2;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocksNeeded = 125;
		int rocksOwned = 64;
		int rocksNeeded = totalRocksNeeded - rocksOwned;

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int marblesOwned = 38;
		int marblesMissing = 15;
		int marblesCurrentlyOwned = marblesOwned - marblesMissing;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int distanceToConcert = 78;
		int distanceDrove = 32;
		int distanceLeftToDrive = distanceToConcert - distanceDrove;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */
		int timeSpentShovelingInTheMorning = 90;
		int timeSpentShovelingInTheAfternoon = 45;
		int totalTimeSpentShoveling = timeSpentShovelingInTheAfternoon + timeSpentShovelingInTheMorning;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int hotdogsBought = 6;
		double hotdogsCost = 0.50;
		double moneySpentOnHotdogs = hotdogsBought * hotdogsCost;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int moneyMrsHiltHas = 50;
		int costOfPencil = 7;
		int numberOfPencilsThatCouldBeBought = moneyMrsHiltHas / costOfPencil;

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int butterfliesSeen = 33;
		int orangeButterflies = 20;
		int redButterflies = butterfliesSeen - orangeButterflies;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		double moneyKateGaveToClerk = 1.00;
		double costOfCandy = 0.54;
		double changeReturned = moneyKateGaveToClerk - costOfCandy;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int treesInBackyard = 13;
		int treesPlannedToPlant = 12;
		int totalTreesInBackyard = treesInBackyard + treesPlannedToPlant;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int daysToSeeGrandma = 2;
		int hoursInADay = 24;
		int hoursUntilSheSeesGrandma = daysToSeeGrandma * hoursInADay;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int cousinsKimHas = 4;
		int piecesOfGumToGiveToEachCousin = 5;
		int totalPiecesOfGumNeeded = cousinsKimHas * piecesOfGumToGiveToEachCousin;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		double moneyDanHas = 3.00;
		double costOfCandyBar = 1.00;
		double moneyDanHasAfterSpending = moneyDanHas - costOfCandyBar;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsInTheLake = 5;
		int numberOfPeopleOnEachBoat = 3;
		int numberOfPeopleOnBoats = boatsInTheLake * numberOfPeopleOnEachBoat;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int numberOfLegosEllenHad = 380;
		int numberOfLegosLost = 57;
		int numberOfLegosRemaining = numberOfLegosEllenHad - numberOfLegosLost;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int numberOfMuffinsBaked = 35;
		int numberOfMuffinsWantingToBake = 83;
		int numberOfMuffinsNeedingToBake = numberOfMuffinsWantingToBake - numberOfMuffinsBaked;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int crayonsBelongingToWilly = 1400;
		int crayonsBelongingToLucy = 290;
		int differenceInCrayons = crayonsBelongingToWilly - crayonsBelongingToLucy;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int numberOfStickersOnAPage = 10;
		int numberOfPagesOfStickers = 22;
		int totalNumberOfStickers = numberOfStickersOnAPage * numberOfPagesOfStickers;

        /* Exercise 39
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int AmountOfCupcakes = 96;
		int numberOfChildrenToShare = 8;
		int numberOfCupcakesEachPersonGets = AmountOfCupcakes / numberOfChildrenToShare;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int gingerBreadCookiesMade = 47;
		int numberOfCookiesContainedInEachJar = 6;
		int numberOfCookiesNotPlacedInAJar = gingerBreadCookiesMade % numberOfCookiesContainedInEachJar;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int croissantsPrepared = 59;
		int numberOfNeighborsToGiveCroissants = 8;
		int croissantsLeftWithMarian = 59 % 8;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesOnATrayAtATime = 12;
		int totalAmountOfCookiesToBePrepared = 276;
		int traysNeeded = totalAmountOfCookiesToBePrepared / cookiesOnATrayAtATime;

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int pretzelsMade = 480;
		int oneServingOfPretzels = 12;
		int numberOfServingsOfPretzelToPrepare = pretzelsMade / oneServingOfPretzels;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int lemonCupcakesBaked = 53;
		int cupcakesLeftAtHome = 2;
		int cupcakesPerBox = 3;
		int boxesOfCupcakesGiven = (lemonCupcakesBaked - cupcakesLeftAtHome) / cupcakesPerBox;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int carrotSticksPrepared = 74;
		int numberOfPeople = 12;
		int carrotSticksRemaining = carrotSticksPrepared % numberOfPeople;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int numberOfTeddyBears = 98;
		int teddyBearsPerShelf = 7;
		int shelvesFilled = numberOfTeddyBears / teddyBearsPerShelf;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int maxNumberOfPicturesContainedInAlbum = 20;
		int totalNumberOfPictures = 480;
		int albumsNeeded = totalNumberOfPictures / maxNumberOfPicturesContainedInAlbum;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int tradingCardsCollected = 94;
		int maxNumberOfCardsInFullBox = 8;
		int boxesFilled = tradingCardsCollected / maxNumberOfCardsInFullBox;
		int boxesUnfilled = tradingCardsCollected % maxNumberOfCardsInFullBox;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int booksToBeDistributed = 210;
		int numberOfShelvesRepaired = 10;
		int booksEachShelfContains = booksToBeDistributed / numberOfShelvesRepaired;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		double croissantsBaked = 17;
		double numberOfGuests = 7;
		double croissantsForEachGuest = croissantsBaked / numberOfGuests;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 12 x 14 rooms?
	    Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
	    */
		double hoursBillCanPaintRoom = 2.15;
		double hoursJillCanPaintRoom = 1.90;
		double hoursBillAndJillCanPaintARoom = hoursBillCanPaintRoom + hoursJillCanPaintRoom;
		double hoursBillAndJillCanPaintFiveRooms = hoursBillAndJillCanPaintARoom * 5;

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */
		String firstName = "Grace";
		String lastName = "Hopper,";
		String middleInitials = "B";

		String fullName = lastName + " " + firstName + " " + middleInitials + ".";

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */
		double distanceInMilesBetweenNewYorkAndChicago = 800;
		double distanceInMilesTrainAlreadyTravelled = 537;
		double percentageTraveled = distanceInMilesTrainAlreadyTravelled / distanceInMilesBetweenNewYorkAndChicago;
		double percentageOfTripCompleted = percentageTraveled * 100;
		int wholePercentage = (int) percentageOfTripCompleted;
	}

}
