# coddy - java daily challenge

# 2026

## January

### 6 - processUnsignedCheck
Create a function named processUnsignedCheck that receives checkAmount, checkDimensions, checkAge, geometricShapes, and foldCount as its parameters.

The function simulates a complex financial calculation system for an old-fashioned bank, processing unsigned checks and performing various geometric and arithmetic operations to determine the final value and validity of each check.

Implement the following calculations and validations:
- Convert the check amount to a fraction and multiply it by (checkAge + 1) / checkAge.
- Calculate the surface area and volume of the check using the given dimensions.
- Apply a 2% increase to the check value for each fold.
- Calculate the areas of the geometric shapes drawn on the check and use them to adjust the check value. For simplicity, assume:
	Triangle area = 0.5 * base * height (use 10 for base and height)
	Circle area = π * r^2 (use 5 for radius)
	Square area = side^2 (use 10 for side length)
- Add the total area of shapes to the check value.
- Raise the check value to the power of the number of shapes, then take the nth root where n is the number of folds.
- Implement a validation algorithm: the check is valid if the product of its dimensions is greater than 1,000,000 and the number of shapes is less than 5.
- Format the final adjusted value as a percentage of the original value.

Parameters:
- checkAmount (String): The original amount on the check (e.g., "1234.56").
- checkDimensions (int[]): An array containing the length, width, and height of the check in millimeters.
- checkAge (float): The age of the check in years.
- geometricShapes (String[]): An array of strings representing geometric shapes drawn on the check (e.g., ["triangle", "circle", "square"]).
- foldCount (int): The number of folds in the check.

The function returns a string containing the adjusted check value, validity status, and geometric properties in the following format:
- "Adjusted Value: X%, Valid: true/false, Surface Area: Y mm², Volume: Z mm³"
- Where X is the adjusted value as a percentage of the original (rounded to 2 decimal places), Y is the surface area (rounded to 2 decimal places), and Z is the volume (rounded to 2 decimal places).

### 5 - planRoadTrip
Create a function named planRoadTrip that receives towns, attractions, familyPreferences, maxDays, and maxTowns as its parameters.

The Smith family is embarking on an adventure-filled road trip across the countryside in their old wagon. Your task is to help them plan the optimal itinerary using advanced set theory and complex looping structures.

The function should plan and analyze the family's journey through various towns and attractions, using sets to represent different aspects of the trip and loops to process and manipulate this data. The goal is to create an itinerary that maximizes the family's preferences while adhering to the given constraints.

Follow these steps to solve the challenge:
- Generate the power set of towns to consider all possible combinations of towns to visit.
- Use set operations to find the intersection between available attractions and family preferences.
- Implement nested loops to iterate through the power set of towns and calculate the optimal route based on maximizing matched preferences and minimizing travel time.
- Use recursion to generate all possible permutations of the selected towns to find the most efficient route.
- Implement a scoring system using set cardinality and custom weighting to rank different itineraries.
- Use loop control statements to optimize the search process and prune unnecessary iterations.

Parameters:
- towns (String[]): An array of town names the family might visit.
- attractions (String[]): An array of attractions available across all towns.
- familyPreferences (String[]): An array of the family's preferred activities or attractions.
- maxDays (int): The maximum number of days for the trip.
- maxTowns (int): The maximum number of towns to visit.

The function returns a String[] representing the optimal road trip itinerary. 
Each element in the array should be a String in the format "Day X: Town - Attraction", where X is the day number, Town is the name of the town visited, and Attraction is the attraction visited in that town.

Constraints:
1 ≤ towns.length ≤ 10
1 ≤ attractions.length ≤ 20
1 ≤ familyPreferences.length ≤ attractions.length
1 ≤ maxDays ≤ 14
1 ≤ maxTowns ≤ towns.length

Note: Ensure your solution is efficient and can handle the maximum constraints. The use of advanced set theory concepts and complex looping structures will be essential to creating an efficient and effective solution.

### 4 - optimizeSeating
Create a function named optimizeSeating that receives int[][] roomLayout and String[] familyMembers as its parameters.

Your task is to create an optimal seating arrangement for a family holiday gathering. The challenge is to maximize seating efficiency, promote conversation, and consider family dynamics, all while working with a complex room layout.

The function should analyze the room layout, determine the best seating arrangement, and place family members accordingly. Your solution should utilize advanced array operations and geometric concepts to solve this real-world problem.

Parameters:
- roomLayout (int[][]): A 2D array representing the dining room. In this array:
	 - 0 represents empty space
	 - 1 represents a table section
	 - -1 represents obstacles or walls
- familyMembers (String[]): An array of strings containing the names of the relatives attending the gathering. The array will contain between 10 and 20 names.

The function should return a 2D string array representing the optimized seating arrangement, with family members' names placed in their assigned seats. Empty seats should be represented by empty strings.

Your solution should consider the following factors:
- Maximize the number of people seated at the table.
- Ensure that no two people are seated directly across from each other to promote conversation.
- Try to seat immediate family members (parents, siblings) closer together. You can assume that family members with the same last name are closely related.
- Distribute "conversation starters" (assume the first 3 names in the familyMembers array are extroverts) evenly around the table.
- Account for any special seating requirements (e.g., place the last 2 names in the familyMembers array in comfortable spots, assuming they are elderly).

Implement your solution using the following techniques:
- Use advanced array operations such as map, filter, and reduce to process family member data and seating preferences.
- Apply slice and splice to modify the seating arrangement as needed.
- Utilize concat to combine different sections of the table if necessary.
- Apply geometric concepts to:
	- Calculate distances between seats to optimize conversation potential.
	- Determine the shape of the table from the 2D array input.
- Apply transformations to the seating arrangement to improve overall satisfaction.

Note: Ensure your solution is efficient and well-structured, ideally between 50 and 99 lines of code.

### 3 - organizeBookSale
Write a function organizeBookSale that takes genres, maxBooksPerTable and returns a string array of table assignments.

The function processes book genres to organize tables at a neighborhood book sale, assigning detective novels to the "Mystery" table and other genres to "General" tables.

Logic:
- Loop through the genres array
- Use logical operators to check if genre contains "Detective" or "Mystery" - assign to "Mystery" table
- Use continue to skip processing when a table reaches maximum capacity
- Use break to stop processing once all books are assigned or maximum tables are filled
- Other genres go to numbered "General" tables

Parameters:
- genres (String[]): Array of book genres to organize
- maxBooksPerTable (int): Maximum books allowed per table

Returns: String array of table assignments for each book. 
Format: ["Mystery", "General-1", "Mystery", "General-2"]

### 2 - examineAntiques
Create a function named examineAntiques that receives objects and rotations as its parameters.

The function simulates a curious collector examining antique pewter objects on a rotating display in a museum. The collector will examine the objects over several rotation cycles, reversing the display each time and potentially removing objects for closer inspection.

Parameters:
- objects (String[]): An array of strings representing the names of pewter objects on the display.
- rotations (int): The number of rotation cycles to perform.
The function should perform the following operations:

For each rotation cycle (up to rotations or until objects is empty):
- Reverse the entire objects array.
- Examine each object in the current order:
	- If the object name length is greater than 5, add it to a result array.
	- If the object name contains the word "rare", immediately end the current rotation cycle (use break).
	- If the object name starts with a vowel (a, e, i, o, u), skip it and move to the next object (use continue).
- After each full rotation, remove the last object from the objects array.

The function returns a String[] containing the names of the objects that the collector decided to examine more closely (added to the result array during the process).

### 1 - catalogMedicalBooks
**Write a function catalogMedicalBooks that takes catalogEntries and returns a formatted status report for the medical research library.

The function processes catalog entries to determine book availability and categorizes medical literature types based on title keywords.

Logic:
- Parse each entry to extract title, author, and checkout status
- Categorize books: 
	"Surgery" (contains "surgical" or "surgery"), 
	"Research" (contains "research" or "methodology"), "General" (all others)
- Determine availability: "Available" if checkout status is "IN", "Checked Out" if "OUT"

Format each book as: "[Category] - [Title] by [Author]: [Status]"

Parameters:
- catalogEntries (String[]): Array of catalog entries in format "Title|Author|Status"

Returns: String with formatted catalog report, each book on a new line. 
Format: Surgery - Advanced Surgical Techniques by Dr. Smith: Available Research - Clinical Research Methods by Dr. Johnson: Checked Out General - Medical Ethics by Dr. Brown: Available**

# 2025
01. countWildFlowers - loops
02. candlelitCountdownPrayer - conditionals
03. swapFirstandLastCharacters - string manipulation
04. isJailNumber - loops and arithmetic
05. simulateSkiPath - arrays
06. craftGlimmeringStone - arrays and arithmetic
07. isBacterialCode - string manipulation
08. aquariumCodeTranslator - string manipulation
09. organizeHerbInventory - string manipulation
10. conductExperiment - arrays
11. stormImpact - arrays
12. drawCharacterHead - arrays
13. countStars - string manipulation
14. debateScorer - arrays
15. generateRehearsalSchedule - arrays and loops and conditionals
16. reverseArrayExceptMultiplesOfFive - arrays and loops
17. slideDown - stringbuilder
18. mixPirateBitters - hashset and stringbuilder
19. createFlavorMatrix - 2d array
20. transformStrings - stringbuilder
21. analyzeMineral - arrays
22. createRanchSchedule - lists and stringbuilder
23. calculateBanquetBudget - conditionals
24. preparePicnicBasket - arrays
25. reverseChemicalSequence - arrays
26. organizeHillsideHouses - arrays and lists and conditionals
27. adjustGreenhouseTemperatures - arrays and conditionals
28. calculateSchedule - conditional-switch
29. mergeDroplets - arraylist
30. packCampingContainers - arraylist
31. organizeLabCompartments - stringbuilder
32. reverseAndCompare - arrays
33. reverseElement - stringbuilder
34. examineCurio - stringbuilder and sets
35. reverseSoupIngredients - arrays
36. waterRarePlants - arrays and loops and conditionals
37. findTreasure - arrays and loops and conditionals
38. findQuietestShelf - conditionals
39. simulatePufferfishInflation - stringbuilder
40. countStarsInForest - arrays and conditionals
41. morningGardenWalk - loops
42. countSpecialWaypoints - loops
43. tenseBillingConversation - conditionals
44. getItemsToPack - lists and conditionals
45. checkPicnicBasket - conditionals
46. quiltPatchCounter - conditionals
47. adjustMultivibratorFrequency - arrays
48. gardenPestRemoval - conditionals
49. findShellNumbers - lists
50. decodeMessage - strings
51. identifySeeds - conditionals
52. sellExoticPlants - conditionals
53. simulateTheologicalDebate - loops and conditionals
54. tendToPlants - arrays
55. createCheckersBoard - 2d arrays
56. reverseTeaArray - arrays
57. radiotherapistMutter - stream
58. forestHikePathTracker - loops
59. findQuietestSpot - conditionals
60. divideSandwiches - conditionals
61. prepareEquipment - arrays and arraylists
62. picnicBasketSorter - arrays
63. reverseString - strings
64. countBirdTypes - arrays
65. calculateDocumentPages - loops and conditionals
66. catalogSculptures - arrays
67. countPicnicBaskets - conditionals
68. analyzeAcornCollection - hashmap
69. discussRabbetTechnique - arrays
70. countDataInMaze - loops and conditionals
71. generateSleepySalesPitch - stringbuilder
72. isHarmonyNumber - arrays and loops
73. arrangeBotanicalSpecimens - arrays and strings
74. mountainTrailAscent - loops and arrays
75. calculateTacoOrder - decimalformat
76. calculateHarvest  - primitives
77. generateFortressCode - stringbuilder
78. dreamFestivalSorter - arrays
79. analyzeSpecimens - arrays
80. sortPicnicItems - arrays
81. prepareCakeOrder - arrays and arraylists
82. parkPlaytime - stringbuilder
83. analyzePlantGrowth - arrays and conditionsla
84. updateFishPrices - arrays and conditionals
85. categorizeCreature - stream and collections
86. determineWaterBottleType - conditionals
87. findPicnicSpot - conditionals
88. createTeaPartyInvitation - Lists and arraylist and stringbuilder
89. createFlowerGarland - stringbuilder
90. copyMachineGlitch - array and arraylist
91. rearrangeSeating - loops
92. organizeCustomerQueue - arrays and comparator
93. analyzePlantDNA - stringbuilder
94. analyzeSpecimen - conditionals
95. shepherdCall - stream
96. analyzeCrystals - conditionals
97. countFlowersAndPainLevel - arrays
98. decodeHeistMessage - stringbuilder
99. generateBowlingMessage - conditionals
100. realignEquipment - 2d arrays
101. feedDucks - primitive variables
102. decipherAncientMessage - string manipulation
103. analyzeInsectCode - stringbuilder
104. decodeArtifactLabels - sets
105. decodeThiefMessage - stringbuilder
106. courtDebateIntensity - loops
107. createTrailMessage - stringbuilder
108. maxFillingsPerPerson - loops
109. harvestCotton - array matrix
110. isLuckyYear - exception handling
111. countCircularObjects - conditionals
112. reversePathSections - stringbuilder
113. calculateMineralEssence - binary conversion
114. mistForestRunners - loops and arrays
115. countSeashells - loops
116. countCraters - loops
117. ancientNumeralConverter - arrays and collections
118. countSheep - loops
119. calculatePicnicSupplies - strings
120. duckPondVisit - loops and arraylist
121. ancientGatewayCode - loops and arrays
122. findShortestQueue - arrays
123. createSetlist - Arraylist and hashmap
124. calculateDebateScore - strings
125. protectSandcastles - loops
126. convertToBinaryCountOnes - Stringbuilder
127. findTreeInPark - loops
128. colcannonCalculator - arrays and loops and Stringbuilder
129. reverseScaleAndCheckPalindrome - arrays and loops
130. haveEnoughSandwiches - loops
131. navigateTerrain - loops
132. reverseSelectedTents - arraylist
133. findHiddenTreasure - arrays
134. countSteps - arrays and loops
135. findCommonWords - hashset
136. prepareSupplyPackages - arrays
137. isPackedSafely - arrays and conditionals
138. tuneInstruments - arrays and conditionals
139. findInsect - arraylist
140. upgradeCartWheel - arrays
141. decipherText - string manipulation
142. vampireBatCode - hashmaps
143. selectChalcedonyGemstones - lists and arraylists
144. organizeFlowerCollection - sets
145. analyzeDefoliation - arraylist and lists
146. findTool - arrays
147. prepareCheckroll - classes and hashmaps
148. bazaarInventory - matrix and hashtable
149. createFieldNotes - arrays and stringbuilder
150. findMisplacedItems - arrays and arraylists
151. analyzePlantSpecimens - arrays
152. vampireNightOut - map and hashmap
153. extractJournalInfo - list and arraylist
154. assignWorkshopStorage - arrays
155. conductSolubilityExperiment - arrays
156. exploreApothecaryShop  - arraylist
157. calculateCabinRenovation - array
158. analyzeBirdWatchingExperience - map and hashmap
159. formatHarvestDistribution - Stringbuilder
160. natureWalkRecorder - linkedlist
161. organizeHealthPosts - arrays and lists
162. organizeOfficeSupplies - arrays and loops
163. analyzeColumnistStyle - sets
164. rearrangeDisplay - arrays
165. manageAntiques - maps and lists
166. mirrorNeurons - 2D arrays
167. analyzeVetClinicArgument - hashmap
168. formatAnimalDescriptions - arrays
169. analyzeWildflowerHeights - arrays
170. plumpCushions - arrays
171. simulateGrowth - arrays
172. organizeWorkshopInventory - nodes
173. classifyHandBones - hashmaps
174. analyzeCranberrySap - arrays
175. categorizeSpecimens - arraylist
176. summarizeFuelTransactions - lists and collections
177. generateFestivalSeating - 2d arrays
178. manageReservations - lists
179. processRenovationTasks - stringbuilder
180. countRarePlants - arrays
181. mergeInventories - array lists
182. geothermalDescent - arrays
183. picnicBlanketPattern - 2d arrays
184. generateExhibitLabels - 2d arrays
185. mergeInventories - arraylist
186. manageCoffeeShopOrders - arraylist
187. simulateFibonacciInNature - arrays
188. modifySpeech - arrays
189. yogaSessionAnalyzer - stringbuilder
190. organizeFairLayout - lists and 2d arrays
191. generateComplianceReport - lists and sets
192. documentMedicalProcedure - arrays
193. geometricOdyssey - Arrays
194. hillsidePicnic - arraylist
195. exploreHabitat - stringbuilder
196. createJournalEntry - conditionals
197. analyzeEventImpact - streams
198. processWeatherData - stringbuilder ascii
199. organizeFiles - lists
200. culturalFestivalAnalyzer - arrays
201. analyzeJungleEcology - arrays
202. organizeFestivalProduce - arraylist
203. analyzePeatBogLayers - sets and maps
204. organizeEquipment - maps
205. illuminateStreet - ArrayList
