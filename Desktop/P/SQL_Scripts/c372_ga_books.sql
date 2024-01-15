-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: c372_ga
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `author` varchar(100) NOT NULL,
  `bkseries` varchar(255) DEFAULT NULL,
  `bktype` varchar(50) NOT NULL,
  `descriptions` varchar(5000) NOT NULL,
  `genre` varchar(100) NOT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8el3ddb59ciucupyc17vu7835` (`category_id`),
  CONSTRAINT `FK8el3ddb59ciucupyc17vu7835` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Natalie Sparks','Hearts Entwined Series','Paperback','In the charming town of Harmony Harbor, where rumors swirl and love is the last thing they expect, meet Harper Turner, a no-nonsense journalist, and Ethan Caldwell, a charismatic small-town mayor. \'Hearts Entangled,\' the kickoff to the Hearts Entwined Series, spins a tale of witty banter, unexpected alliances, and love brewing beneath the surface. As Harper investigates a quirky local festival, she finds herself at odds with the charismatic mayor. Little do they know, the sparks flying between them aren\'t just from their clashes. Join Harper and Ethan on a journey of humorous misunderstandings and surprising revelations as they discover that sometimes the road to love is paved with unexpected detours.','Romance','Book1.png','Hearts Entangled',10.99,799,1),(2,'Elena Harper','','Paperback','In the picturesque town of Harbor Bay, where passion takes a dark turn and love transforms into obsession, meet Emily Stevens and Alex Matthews. \'Obsession Unveiled\' delves into the complex layers of desire, possession, and the unraveling of a love that knows no bounds. Emily, a talented artist, finds her life entwined with Alex, a charming but enigmatic stranger. What starts as a whirlwind romance soon takes a sinister turn as Alex\'s love transforms into an all-consuming obsession. Emily\'s world spirals into chaos as she becomes the unwilling subject of Alex\'s increasingly intrusive and possessive behavior. As Emily grapples with the thin line between love and obsession, she must navigate the dangerous game that Alex plays. A chilling tale unfolds as secrets are revealed, and Emily finds herself trapped in a web of psychological manipulation. \'Obsession Unveiled\' is a gripping psychological thriller that explores the haunting depths of an unrelenting love that refuses to let go. Will Emily break free from the clutches of obsession, or will the darkness of Alex\'s love consume them both?','Psychological Thriller','Book2.png','Obsession Unveiled',14.99,499,2),(3,'Zahra Alarid','Sands of Eternity','Paperback','In the mystical land of Zephyrria, where the winds carry ancient secrets and the sands conceal hidden truths, embark on a quest with the mysterious huntress Leyla Azhar. \'Whispers of the Silent Sands\' unfolds a tale of perilous journeys, forgotten magic, and the quest for a lost relic that could change the fate of a kingdom. Leyla, known as the Silent Phoenix, is tasked with an arduous mission—to retrieve the fabled Emberstone hidden deep within the heart of the Forbidden Desert. Legends speak of its power to awaken ancient forces that could either save or doom the realm. As Leyla ventures into the treacherous sands, she discovers that she is not the only seeker in pursuit of the elusive relic. Joined by a band of unlikely allies—a charismatic rogue with a haunted past, a scholarly mage harboring forbidden knowledge, and a spirited healer with a secret gift—Leyla must navigate a landscape fraught with peril, unravel riddles left by an ancient civilization, and confront the shadows of a forgotten prophecy. As the whispers of the silent sands guide them, Leyla and her companions face trials that test their mettle and challenge their beliefs. Will they uncover the Emberstone\'s secrets and prevent impending catastrophe, or will the sands of time bury their quest in an eternal silence?','Fantasy','Book3.png','Whispers of the Silent Sands',18.66,562,3),(4,'A.R. Sterling','\"The Shadows Unveiled\" Series ','Paperback','In the shadowy underbelly of the city, where secrets are traded like currency and trust is a dangerous game, enter the pulse-pounding world of \'Dangerous Games.\' Detective Elena Monroe, a tenacious investigator with a haunted past, is drawn into a web of intrigue when a series of high-stakes, life-or-death games start playing out on the city\'s dark streets.\r\n\r\nThe enigmatic mastermind behind these dangerous games remains shrouded in mystery, leaving a trail of cryptic clues and victims in their wake. Elena must unravel the twisted motives behind each challenge, leading her into a realm where alliances are fragile, and danger lurks around every corner.\r\n\r\nAs the stakes escalate, Elena finds herself caught in a cat-and-mouse game with the elusive perpetrator, pushing the limits of her investigative skills and challenging her own convictions. The line between right and wrong blurs as the games become increasingly personal, revealing a connection between Elena and the shadowy figure orchestrating the chaos.\r\n\r\n\'Dangerous Games\' is the first instalment in \'The Shadows Unveiled\' Series, a heart-pounding thriller that explores the cost of justice, the depths of human darkness, and the razor\'s edge between survival and obsession. Will Elena unmask the puppeteer behind the dangerous games, or will she become entangled in a web of deception that threatens to consume her?','Thriller','Book4.png','Dangerous Games',16,600,2),(5,'Zara Malik','','Paperback','In the vibrant city of Crescent Cove, where the sea breeze carries tales of love and the stars hold whispered secrets, immerse yourself in the heartfelt journey of \'Notes Between Stars.\' Aspiring journalist Amina Khan discovers an old journal in the dusty attic of her grandmother\'s bookstore, unlocking a poignant love story that transcends time.\r\n\r\nThe journal, written by starry-eyed teenager Zayn Abbas, unfolds a series of notes chronicling his blossoming connection with the spirited and mysterious Leila Ahmed. Their paths cross in unexpected ways, and each note becomes a snapshot of their shared laughter, dreams, and the challenges that test their young love.\r\nAs Amina delves into the past, she uncovers parallels between Zayn and Leila\'s story and her own journey of self-discovery and first love. The notes, written between stolen glances and chance encounters, offer a timeless perspective on the complexities of love, family, and navigating the cultural tapestry that weaves through Crescent Cove.\r\n\r\n\'Notes Between Stars\' is a tender exploration of connection, courage, and the universal language of love. Will Amina find inspiration for her own story within the faded pages of the journal, or will the notes between stars guide her toward a love as enduring as the night sky?\r\n','Romance','Book5.png','Notes Between Stars',12.99,500,1),(6,'Marcus Taylor','','Paperback','In the enigmatic city of Shadows Hollow, where every alley holds untold secrets and the fine line between reality and illusion blurs, delve into the mind-bending narrative of \'Invisible Agreements.\' Jake Mitchell, a renowned psychologist, stumbles upon a series of mysterious contracts that promise to fulfill people\'s deepest desires. However, the cost may be more than they bargained for.\r\nAs Jake investigates the origins of these invisible agreements, he becomes entangled in a web of psychological manipulation, hidden agendas, and a shadowy figure known only as \'The Architect.\' Each contract leads Jake deeper into the labyrinth of human desires, and the boundaries between the real and the surreal begin to dissolve.\r\nAs he deciphers the hidden meanings within the contracts, Jake is forced to confront his own unresolved traumas and the dark corners of his mind. The city itself seems to pulse with a malevolent energy, and Jake must navigate through the illusions to unravel the truth before he becomes a victim of his own investigation.\r\n\'Invisible Agreements\' is a psychological thriller that explores the price of desires, the complexities of the human psyche, and the fine line between sanity and madness. Will Jake break free from the invisible agreements that bind him, or will Shadows Hollow claim another victim in its twisted game of illusions?\r\n','Psychological Thriller','Book6.png','Invisible Agreements',14.99,600,2),(7,'Aria Emberwood','The Eldoria Chronicles','Paperback','Embark on a magical journey in \"Whispers of the Hidden Grove,\" a young adult fantasy adventure penned by the enchanting Aria Emberwood. Meet Elara Shadowleaf, a spirited young mage with a mysterious past, and Kaelin Stormrider, a charming rogue with a knack for uncovering ancient secrets.\r\nIn the mystical realm of Eldoria, a hidden grove is said to hold the key to unlocking extraordinary powers. Elara and Kaelin, drawn together by destiny, embark on a perilous quest to find the grove and unravel the mysteries that lie within. Along the way, they encounter mythical creatures, cryptic riddles, and an ancient prophecy that foretells the rise of a new era.\r\n\"Whispers of the Hidden Grove\" is a tale of friendship, magic, and the courage to face the unknown. Will Elara and Kaelin uncover the secrets hidden within the grove, or will the shadows of Eldoria keep their mysteries shrouded in darkness?\r\nImmerse yourself in the fantastical narrative of \"Whispers of the Hidden Grove,\" where every whisper in the wind and every rustle of leaves holds the promise of a magical adventure.\r\n','Fantasy,Mystery,Adventure','Book7.png','Whispers of the Hidden Grove',18.99,490,3),(8,'Aria Steele','','Hardcover','Experience the thrilling dance of love and suspense in \"Heart\'s Veil,\" a contemporary romance spun by the enchanting Aria Steele. Meet Olivia Bennett, a successful wedding planner with a penchant for turning dreams into reality, and Ethan Sterling, a mysterious photographer with a past shrouded in secrecy.\r\nAs Olivia orchestrates the grand wedding of a high-profile couple, she stumbles upon a series of anonymous love letters that hint at a hidden romance. Intrigued, she enlists the help of Ethan to unravel the mystery behind the heartfelt notes. However, as they dig deeper into the lives of the bride and groom, they uncover a web of lies, betrayal, and a dangerous secret that could shatter the illusion of perfect love.\r\n\"Heart\'s Veil\" is a tale of passion, suspense, and the delicate threads that bind two hearts together. Will Olivia and Ethan navigate the complexities of love and unravel the secrets hidden behind the heart\'s veil, or will they become entangled in a web of deception that threatens to tear them apart?\r\nImmerse yourself in the riveting narrative of \"Heart\'s Veil,\" where every heartbeat conceals a secret and every moment is a step closer to the unveiling of true love.','Contemporary, Romance, Suspense','Book8.png','Heart\'s Veil',25.99,600,1),(9,'Eloise Beaumont','','Hardcover','Step into the opulent world of 18th-century Versailles in \"Whispers of Versailles,\" an enthralling historical mystery penned by the evocative Eloise Beaumont. Meet Isabelle Laurent, a skilled portrait artist with a penchant for uncovering hidden truths, and Henri Duval, a shrewd investigator tasked with unravelling the mysteries that lurk within the gilded halls of the palace.\r\nAs whispers of a forbidden romance and political intrigue echo through Versailles, Isabelle finds herself commissioned to paint a portrait of the enigmatic Madame Celeste—a woman with a secret that could shatter the delicate façade of courtly life. When Madame Celeste mysteriously vanishes, Isabelle and Henri join forces to navigate the labyrinth of palace secrets, where alliances are forged in whispers and betrayal lurks in the shadows.\r\nAgainst the backdrop of lavish balls and clandestine meetings, Isabelle and Henri race against time to uncover the truth that could alter the course of history. \"Whispers of Versailles\" is a tapestry of mystery and romance that transports readers to a world where power, passion, and peril collide in the grandeur of the Sun King\'s court.\r\nWill Isabelle and Henri untangle the threads of deception, or will the whispers of Versailles become a haunting melody that resonates through the corridors of time?\r\nImmerse yourself in the splendour of courtly intrigue, feel the pulse of a bygone era, and let \"Whispers of Versailles\" be your guide through a captivating tale of mystery and betrayal.\r\n','Historical Mystery','Book9.png','Whispers of Versailles',24.99,119,4),(10,'Sophia Reynolds','','Paperback','Dive into the complexities of human connections in \"Echoes of Solitude,\" a poignant contemporary drama penned by the insightful Sophia Reynolds. Meet Emma Thompson, a successful architect with a penchant for solitude, and Daniel Hartman, a compassionate therapist haunted by the ghosts of his past.\r\nWhen Emma\'s meticulously structured life is disrupted by a chance encounter with Daniel, they find themselves drawn into each other\'s worlds, navigating the delicate balance between connection and solitude. As their lives become intertwined, they confront the echoes of their own vulnerabilities, challenging the boundaries they\'ve constructed to protect their hearts.\r\n\"Echoes of Solitude\" is a soul-stirring exploration of love, loss, and the transformative power of human connection. Against the backdrop of urban landscapes and the quiet solace of nature, Emma and Daniel\'s journey becomes a profound meditation on the choices we make, the scars we carry, and the possibility of redemption through shared moments of vulnerability.\r\nWill Emma and Daniel find solace in each other\'s company, or will the echoes of solitude continue to define their lives?\r\nEmbark on a journey through the emotional landscapes of \"Echoes of Solitude,\" where the quiet echoes of the heart resonate in the spaces between words and the unspoken truths that bind us all.\r\n','Contemporary Drama','Book10.png','Echoes of Solitude',16.99,356,5),(11,'Charlie Jester','','Paperback','Get ready for a laugh-out-loud adventure in \"The Hilarious Heist,\" a comedic romp written by the witty Charlie Jester. Meet Jack Tickleton, a bumbling yet lovable amateur detective, and Samantha Sparkle, a quick-witted con artist with a penchant for mischief.\r\nWhen a priceless rubber chicken goes missing from the eccentric billionaire Sir Percival Pompington\'s collection, Jack and Samantha find themselves inadvertently caught up in a web of absurdity and high jinks. As they attempt to unravel the mystery behind the stolen chicken, they encounter a quirky cast of characters, from kleptomaniac magicians to overenthusiastic museum guards.\r\n\"The Hilarious Heist\" is a rollercoaster of laughter, pratfalls, and unexpected alliances. Will Jack and Samantha outwit the zany suspects and recover the absurdly valuable rubber chicken, or will their attempts at detective work lead to even more hilarity and chaos?\r\nJoin in the uproarious escapades of \"The Hilarious Heist,\" where every page is a punchline, and the comedy caper takes you on a side-splitting journey of laughter and absurdity.\r\n','Comedy','Book11.png','The Hilarious Heist',14.99,70,6),(12,'Aurora Skylark ','Timeless Hearts Saga','Paperback','Embark on a transcendent journey through time and love with \"Ephemeral Echoes,\" a captivating romance spun by the mysterious Aurora Skylark. Meet Celeste Harper, a modern-day artist with a timeless soul, and Alexander Stone, a charismatic 19th-century poet cursed to relive the same day over centuries.\r\nIn a quaint town nestled between eras, Celeste stumbles upon a forgotten journal that reveals Alexander\'s tragic fate. Drawn by an unseen force, she discovers a mystical pocket in time where their worlds collide. As Celeste and Alexander navigate the complexities of love across the ages, they confront the ephemeral nature of time and the enduring power of a connection that transcends centuries.\r\nTold through intertwined perspectives, \"Ephemeral Echoes\" unfolds a narrative of longing, passion, and the pursuit of an everlasting love. Together, Celeste and Alexander must navigate the threads of time that weave around them, attempting to break free from the cyclical nature of their fates.\r\nWill they unravel the mysteries that bind them to a temporal dance, or will they be forever ensnared in the echoes of time\'s embrace? Immerse yourself in the timeless romance of \"Ephemeral Echoes,\" where every heartbeat echoes through the corridors of history.\r\n','Time-traveling Romance ','Book12.png','Ephemeral Echoes',23.99,781,1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-14  4:44:26
