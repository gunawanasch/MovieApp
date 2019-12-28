package com.jetpack.movie.utils;

import com.jetpack.movie.data.source.remote.response.MovieResponse;
import com.jetpack.movie.data.source.remote.response.TVShowResponse;
import com.jetpack.movie.model.FavoriteMovieModel;
import com.jetpack.movie.model.FavoriteTVShowModel;
import com.jetpack.movie.model.MovieModel;
import com.jetpack.movie.model.TVShowModel;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieModel> generateDummyMovie() {
        ArrayList<MovieModel> movies = new ArrayList<>();

        movies.add(new MovieModel("429617",
                "lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Spider-Man: Far from Home",
                "2019-07-02",
                "en",
                7.6,
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."));
        movies.add(new MovieModel("920",
                "jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "2006-06-09",
                "en",
                6.7,
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters."));
        movies.add(new MovieModel("301528",
                "w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
                "Toy Story 4",
                "2019-06-21",
                "en",
                7.6,
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."));
        movies.add(new MovieModel("384018",
                "keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "2019-08-02",
                "en",
                6.5,
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw."));
        movies.add(new MovieModel("479455",
                "dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg",
                "Men in Black: International",
                "2019-06-14",
                "en",
                5.9,
                "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization."));
        movies.add(new MovieModel("118340",
                "y31QB9kn3XSudA15tV7UWQ9XLuW.jpg",
                "Guardians of the Galaxy",
                "2014-08-01",
                "en",
                7.9,
                "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser."));
        movies.add(new MovieModel("299534",
                "or06FN3Dka5tukK1e9sl16pB3iy.jpg",
                "Avengers: Endgame",
                "2019-04-26",
                "en",
                8.3,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."));
        movies.add(new MovieModel("299536",
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "2018-04-27",
                "en",
                8.3,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));
        movies.add(new MovieModel("324857",
                "iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "Spider-Man: Into the Spider-Verse",
                "2018-12-14",
                "en",
                8.4,
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."));
        movies.add(new MovieModel("287947",
                "xnopI5Xtky18MPhK40cZAGAOVeV.jpg",
                "Shazam!",
                "2019-03-23",
                "en",
                7.0,
                "A boy is given the ability to become an adult superhero in times of need with a single magic word."));

        return movies;
    }

    public static ArrayList<TVShowModel> generateDummyTVShow() {
        ArrayList<TVShowModel> tvs = new ArrayList<>();

        tvs.add(new TVShowModel("456",
                "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "1989-12-17",
                "en",
                7.1,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."));
        tvs.add(new TVShowModel("1412",
                "mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "2012-10-10",
                "en",
                5.8,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."));
        tvs.add(new TVShowModel("60735",
                "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "2014-10-07",
                "en",
                6.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."));
        tvs.add(new TVShowModel("1403",
                "cXiETfFK1BTLest5fhTLfDLRdL6.jpg",
                "Marvel's Agents of S.H.I.E.L.D.",
                "2013-09-24",
                "en",
                6.8,
                "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary."));
        tvs.add(new TVShowModel("1668",
                "7buCWBTpiPrCF5Lt023dSC60rgS.jpg",
                "Friends",
                "1994-09-22",
                "en",
                7.9,
                "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan."));
        tvs.add(new TVShowModel("31910",
                "zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                "Naruto Shippūden",
                "2007-02-15",
                "ja",
                7.6,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki."));
        tvs.add(new TVShowModel("46298",
                "yWBcBIO9OrF3E85C5Arols6QNnG.jpg",
                "Hunter x Hunter",
                "2011-10-02",
                "ja",
                8.4,
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world."));
        tvs.add(new TVShowModel("12971",
                "lCvOCn1Hq0ugBL6T8SyMoaCWNOc.jpg",
                "Dragon Ball Z",
                "1989-04-26",
                "ja",
                8.0,
                "Five years have passed since the fight with Piccolo Jr. and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans."));
        tvs.add(new TVShowModel("30984",
                "jLKCX4hDP5DbcsPHpOSs6CMWoNe.jpg",
                "Bleach",
                "2004-10-05",
                "ja",
                7.8,
                "For as long as he can remember, Ichigo Kurosaki has been able to see ghosts. But when he meets Rukia, a Soul Reaper who battles evil spirits known as Hollows, he finds his life is changed forever. Now, with a newfound wealth of spiritual energy, Ichigo discovers his true calling: to protect the living and the dead from evil."));
        tvs.add(new TVShowModel("2661",
                "9nlyhxpszQ34joVXMM2PjXvyBvn.jpg",
                "Kamen Rider",
                "1971-04-03",
                "ja",
                5.5,
                "A Japanese anthology series centered around a man who transforms into a bug-themed superhero."));

        return tvs;
    }

    public static ArrayList<MovieResponse> generateRemoteDummyMovie() {
        ArrayList<MovieResponse> movies = new ArrayList<>();

        movies.add(new MovieResponse("429617",
                "lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Spider-Man: Far from Home",
                "2019-07-02",
                "en",
                7.6,
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."));
        movies.add(new MovieResponse("920",
                "jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "2006-06-09",
                "en",
                6.7,
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters."));
        movies.add(new MovieResponse("301528",
                "w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
                "Toy Story 4",
                "2019-06-21",
                "en",
                7.6,
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."));
        movies.add(new MovieResponse("384018",
                "keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "2019-08-02",
                "en",
                6.5,
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw."));
        movies.add(new MovieResponse("479455",
                "dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg",
                "Men in Black: International",
                "2019-06-14",
                "en",
                5.9,
                "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization."));
        movies.add(new MovieResponse("118340",
                "y31QB9kn3XSudA15tV7UWQ9XLuW.jpg",
                "Guardians of the Galaxy",
                "2014-08-01",
                "en",
                7.9,
                "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser."));
        movies.add(new MovieResponse("299534",
                "or06FN3Dka5tukK1e9sl16pB3iy.jpg",
                "Avengers: Endgame",
                "2019-04-26",
                "en",
                8.3,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."));
        movies.add(new MovieResponse("299536",
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "2018-04-27",
                "en",
                8.3,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));
        movies.add(new MovieResponse("324857",
                "iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "Spider-Man: Into the Spider-Verse",
                "2018-12-14",
                "en",
                8.4,
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."));
        movies.add(new MovieResponse("287947",
                "xnopI5Xtky18MPhK40cZAGAOVeV.jpg",
                "Shazam!",
                "2019-03-23",
                "en",
                7.0,
                "A boy is given the ability to become an adult superhero in times of need with a single magic word."));

        return movies;
    }

    public static ArrayList<TVShowResponse> generateRemoteDummyTVShow() {
        ArrayList<TVShowResponse> tvs = new ArrayList<>();

        tvs.add(new TVShowResponse("456",
                "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "1989-12-17",
                "en",
                7.1,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."));
        tvs.add(new TVShowResponse("1412",
                "mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "2012-10-10",
                "en",
                5.8,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."));
        tvs.add(new TVShowResponse("60735",
                "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "2014-10-07",
                "en",
                6.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."));
        tvs.add(new TVShowResponse("1403",
                "cXiETfFK1BTLest5fhTLfDLRdL6.jpg",
                "Marvel's Agents of S.H.I.E.L.D.",
                "2013-09-24",
                "en",
                6.8,
                "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary."));
        tvs.add(new TVShowResponse("1668",
                "7buCWBTpiPrCF5Lt023dSC60rgS.jpg",
                "Friends",
                "1994-09-22",
                "en",
                7.9,
                "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan."));
        tvs.add(new TVShowResponse("31910",
                "zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                "Naruto Shippūden",
                "2007-02-15",
                "ja",
                7.6,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki."));
        tvs.add(new TVShowResponse("46298",
                "yWBcBIO9OrF3E85C5Arols6QNnG.jpg",
                "Hunter x Hunter",
                "2011-10-02",
                "ja",
                8.4,
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world."));
        tvs.add(new TVShowResponse("12971",
                "lCvOCn1Hq0ugBL6T8SyMoaCWNOc.jpg",
                "Dragon Ball Z",
                "1989-04-26",
                "ja",
                8.0,
                "Five years have passed since the fight with Piccolo Jr. and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans."));
        tvs.add(new TVShowResponse("30984",
                "jLKCX4hDP5DbcsPHpOSs6CMWoNe.jpg",
                "Bleach",
                "2004-10-05",
                "ja",
                7.8,
                "For as long as he can remember, Ichigo Kurosaki has been able to see ghosts. But when he meets Rukia, a Soul Reaper who battles evil spirits known as Hollows, he finds his life is changed forever. Now, with a newfound wealth of spiritual energy, Ichigo discovers his true calling: to protect the living and the dead from evil."));
        tvs.add(new TVShowResponse("2661",
                "9nlyhxpszQ34joVXMM2PjXvyBvn.jpg",
                "Kamen Rider",
                "1971-04-03",
                "ja",
                5.5,
                "A Japanese anthology series centered around a man who transforms into a bug-themed superhero."));

        return tvs;
    }

    public static ArrayList<FavoriteMovieModel> generateDummyFavoriteMovie() {
        ArrayList<FavoriteMovieModel> movies = new ArrayList<>();

        movies.add(new FavoriteMovieModel("429617",
                "lcq8dVxeeOqHvvgcte707K0KVx5.jpg",
                "Spider-Man: Far from Home",
                "2019-07-02",
                "en",
                7.6,
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."));
        movies.add(new FavoriteMovieModel("920",
                "jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg",
                "Cars",
                "2006-06-09",
                "en",
                6.7,
                "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters."));
        movies.add(new FavoriteMovieModel("301528",
                "w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg",
                "Toy Story 4",
                "2019-06-21",
                "en",
                7.6,
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."));
        movies.add(new FavoriteMovieModel("384018",
                "keym7MPn1icW1wWfzMnW3HeuzWU.jpg",
                "Fast & Furious Presents: Hobbs & Shaw",
                "2019-08-02",
                "en",
                6.5,
                "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw."));
        movies.add(new FavoriteMovieModel("479455",
                "dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg",
                "Men in Black: International",
                "2019-06-14",
                "en",
                5.9,
                "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization."));
        movies.add(new FavoriteMovieModel("118340",
                "y31QB9kn3XSudA15tV7UWQ9XLuW.jpg",
                "Guardians of the Galaxy",
                "2014-08-01",
                "en",
                7.9,
                "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser."));
        movies.add(new FavoriteMovieModel("299534",
                "or06FN3Dka5tukK1e9sl16pB3iy.jpg",
                "Avengers: Endgame",
                "2019-04-26",
                "en",
                8.3,
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."));
        movies.add(new FavoriteMovieModel("299536",
                "7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Avengers: Infinity War",
                "2018-04-27",
                "en",
                8.3,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."));
        movies.add(new FavoriteMovieModel("324857",
                "iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                "Spider-Man: Into the Spider-Verse",
                "2018-12-14",
                "en",
                8.4,
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."));
        movies.add(new FavoriteMovieModel("287947",
                "xnopI5Xtky18MPhK40cZAGAOVeV.jpg",
                "Shazam!",
                "2019-03-23",
                "en",
                7.0,
                "A boy is given the ability to become an adult superhero in times of need with a single magic word."));

        return movies;
    }

    public static ArrayList<FavoriteTVShowModel> generateDummyFavoriteTVShow() {
        ArrayList<FavoriteTVShowModel> tvs = new ArrayList<>();

        tvs.add(new FavoriteTVShowModel("456",
                "yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
                "The Simpsons",
                "1989-12-17",
                "en",
                7.1,
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."));
        tvs.add(new FavoriteTVShowModel("1412",
                "mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
                "Arrow",
                "2012-10-10",
                "en",
                5.8,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."));
        tvs.add(new FavoriteTVShowModel("60735",
                "wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
                "The Flash",
                "2014-10-07",
                "en",
                6.7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."));
        tvs.add(new FavoriteTVShowModel("1403",
                "cXiETfFK1BTLest5fhTLfDLRdL6.jpg",
                "Marvel's Agents of S.H.I.E.L.D.",
                "2013-09-24",
                "en",
                6.8,
                "Agent Phil Coulson of S.H.I.E.L.D. (Strategic Homeland Intervention, Enforcement and Logistics Division) puts together a team of agents to investigate the new, the strange and the unknown around the globe, protecting the ordinary from the extraordinary."));
        tvs.add(new FavoriteTVShowModel("1668",
                "7buCWBTpiPrCF5Lt023dSC60rgS.jpg",
                "Friends",
                "1994-09-22",
                "en",
                7.9,
                "The misadventures of a group of friends as they navigate the pitfalls of work, life and love in Manhattan."));
        tvs.add(new FavoriteTVShowModel("31910",
                "zAYRe2bJxpWTVrwwmBc00VFkAf4.jpg",
                "Naruto Shippūden",
                "2007-02-15",
                "ja",
                7.6,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki."));
        tvs.add(new FavoriteTVShowModel("46298",
                "yWBcBIO9OrF3E85C5Arols6QNnG.jpg",
                "Hunter x Hunter",
                "2011-10-02",
                "ja",
                8.4,
                "Twelve-year-old Gon Freecss one day discovers that the father he had always been told was dead was alive and well. His Father, Ging, is a Hunter—a member of society's elite with a license to go anywhere or do almost anything. Gon, determined to follow in his father's footsteps, decides to take the Hunter Examination and eventually find his father to prove himself as a Hunter in his own right. But on the way, he learns that there is more to becoming a Hunter than previously thought, and the challenges that he must face are considered the toughest in the world."));
        tvs.add(new FavoriteTVShowModel("12971",
                "lCvOCn1Hq0ugBL6T8SyMoaCWNOc.jpg",
                "Dragon Ball Z",
                "1989-04-26",
                "ja",
                8.0,
                "Five years have passed since the fight with Piccolo Jr. and Goku now has a son, Gohan. The peace is interrupted when an alien named Raditz arrives on Earth in a spacecraft and tracks down Goku, revealing to him that that they are members of a near-extinct warrior race called the Saiyans."));
        tvs.add(new FavoriteTVShowModel("30984",
                "jLKCX4hDP5DbcsPHpOSs6CMWoNe.jpg",
                "Bleach",
                "2004-10-05",
                "ja",
                7.8,
                "For as long as he can remember, Ichigo Kurosaki has been able to see ghosts. But when he meets Rukia, a Soul Reaper who battles evil spirits known as Hollows, he finds his life is changed forever. Now, with a newfound wealth of spiritual energy, Ichigo discovers his true calling: to protect the living and the dead from evil."));
        tvs.add(new FavoriteTVShowModel("2661",
                "9nlyhxpszQ34joVXMM2PjXvyBvn.jpg",
                "Kamen Rider",
                "1971-04-03",
                "ja",
                5.5,
                "A Japanese anthology series centered around a man who transforms into a bug-themed superhero."));

        return tvs;
    }

}
