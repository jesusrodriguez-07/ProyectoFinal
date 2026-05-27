package main;

import combat.*;
import characters.*;
import items.*;
import places.*;
import exceptions.*;

import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		Move tackle = new Move("Tackle", 10, 35);
		Move spark = new Move("Spark", 14, 20);
		Move swift = new Move("Swift", 13, 20);
		Move gust = new Move("Gust", 12, 25);
		Move bodySlam = new Move("Body Slam", 16, 15);
		Move shadowBall = new Move("Shadow Ball", 15, 15);
		Move confusion = new Move("Confusion", 14, 25);
		Move karateChop = new Move("Karate Chop", 13, 25);

		System.out.println("=== WELCOME TO THE POKEMON WORLD ===");
		System.out.print("Enter your Trainer name: ");
		String trainerName = scanner.nextLine();
		Trainer player = new Trainer(trainerName);

		player.getInventory().addItem(new Potion(), 5);
		player.getInventory().addItem(new Pokeball(), 5);

		System.out.println("\nChoose your Starter Pokemon:");
		System.out.println("1. Charmander (Fire)");
		System.out.println("2. Squirtle (Water)");
		System.out.println("3. Bulbasaur (Grass)");

		int choice = -1;
		while (true) {
			System.out.print("Select (1-3): ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
				if (choice >= 1 && choice <= 3) {
					break;
				}
				System.out.println("Invalid choice. Please enter 1, 2, or 3.");
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid number.");
			}
		}

		Pokemon starter = null;
		if (choice == 1) {
			starter = new Charmander("Charmander", 5, 20, 15, 10);
			starter.setMove(0, tackle);
			starter.setMove(1, new Move("Ember", 12, 25));
		} else if (choice == 2) {
			starter = new Squirtle("Squirtle", 5, 22, 12, 14);
			starter.setMove(0, tackle);
			starter.setMove(1, new Move("Water Gun", 12, 25));
		} else {
			starter = new Bulbasaur("Bulbasaur", 5, 21, 13, 12);
			starter.setMove(0, tackle);
			starter.setMove(1, new Move("Vine Whip", 12, 25));
		}

		System.out.println("\nAdding a random companion to your team...");
		Pokemon randomCompanion;
		int randCompanionType = random.nextInt(3);
		if (randCompanionType == 0) {
			randomCompanion = new Pikachu("Pikachu", 5, 18, 16, 8);
			randomCompanion.setMove(0, tackle);
			randomCompanion.setMove(1, spark);
		} else if (randCompanionType == 1) {
			randomCompanion = new Eevee("Eevee", 5, 19, 14, 11);
			randomCompanion.setMove(0, tackle);
			randomCompanion.setMove(1, swift);
		} else {
			randomCompanion = new Pidgey("Pidgey", 5, 17, 13, 9);
			randomCompanion.setMove(0, tackle);
			randomCompanion.setMove(1, gust);
		}
		try {
			player.addPokemon(randomCompanion);
		} catch (FullTeamException e) {
			System.out.println(e.getMessage());
		}

		boolean playing = true;
		while (playing) {
			System.out.println("\n=================================");
			System.out.println("CURRENT STATUS: " + player.getName() + " | Medals: " + player.getMedals());
			System.out.println("=================================");
			System.out.println("Where do you want to go?");
			System.out.println("1. Pewter City (Gym Leader: Brock)");
			System.out.println("2. Cerulean City (Gym Leader: Misty)");
			System.out.println("3. Vermilion City (Gym Leader: Lt. Surge)");
			System.out.println("4. Saffron City (Gym Leader: Sabrina)");
			System.out.println("5. Manage Team (CRUD)");
			System.out.println("6. Exit Game");

			int menuChoice = -1;
			while (true) {
				System.out.print("Select an option: ");
				try {
					menuChoice = Integer.parseInt(scanner.nextLine());
					if (menuChoice >= 1 && menuChoice <= 6) {
						break;
					}
					System.out.println("Invalid choice. Please enter a number between 1 and 6.");
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a valid number.");
				}
			}

			if (menuChoice == 6) {
				playing = false;
				System.out.println("Thanks for playing!");
				break;
			}

			if (menuChoice == 5) {
				System.out.println("\n--- TEAM MANAGEMENT (CRUD) ---");
				System.out.println("1. Create (Catch wild Pokemon)");
				System.out.println("2. Read (View team stats)");
				System.out.println("3. Update (Rename Pokemon)");
				System.out.println("4. Delete (Release Pokemon)");
				System.out.println("5. Back to map");

				int crudChoice = -1;
				while (true) {
					System.out.print("Select an option: ");
					try {
						crudChoice = Integer.parseInt(scanner.nextLine());
						if (crudChoice >= 1 && crudChoice <= 5) {
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid input.");
					}
				}

				if (crudChoice == 1) {
					System.out.println("Searching in the tall grass...");
					Pokemon wildPokemon;
					int randType = random.nextInt(7);

					if (randType == 0) {
						wildPokemon = new Pikachu("Pikachu", 5, 18, 16, 8);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, spark);
					} else if (randType == 1) {
						wildPokemon = new Eevee("Eevee", 5, 19, 14, 11);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, swift);
					} else if (randType == 2) {
						wildPokemon = new Pidgey("Pidgey", 5, 17, 13, 9);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, gust);
					} else if (randType == 3) {
						wildPokemon = new Snorlax("Snorlax", 5, 30, 15, 15);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, bodySlam);
					} else if (randType == 4) {
						wildPokemon = new Gengar("Gengar", 5, 18, 18, 10);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, shadowBall);
					} else if (randType == 5) {
						wildPokemon = new Mewtwo("Mewtwo", 5, 25, 20, 15);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, confusion);
					} else {
						wildPokemon = new Machamp("Machamp", 5, 22, 19, 12);
						wildPokemon.setMove(0, tackle);
						wildPokemon.setMove(1, karateChop);
					}

					try {
						player.addPokemon(wildPokemon);
						System.out.println("Wild " + wildPokemon.getName() + " was caught successfully!");
					} catch (FullTeamException e) {
						System.out.println(e.getMessage());
					}
				} else if (crudChoice == 2) {
					for (int i = 0; i < player.getTeam().size(); i++) {
						Pokemon p = player.getTeam().get(i);
						System.out.println(i + ". " + p.getName() + " | Lvl " + p.getLevel() + " | HP: " + p.getHp()
								+ "/" + p.getMaxHp() + " | XP: " + p.getXp() + "/" + p.getMaxXp());
					}
				} else if (crudChoice == 3) {
					System.out.print("Enter index of Pokemon to rename: ");
					try {
						int index = Integer.parseInt(scanner.nextLine());
						if (index >= 0 && index < player.getTeam().size()) {
							System.out.print("Enter new name: ");
							String newName = scanner.nextLine();
							player.getTeam().get(index).setName(newName);
							System.out.println("Pokemon successfully renamed!");
						} else {
							System.out.println("Invalid index.");
						}
					} catch (NumberFormatException e) {
						System.out.println("Invalid input.");
					}
				} else if (crudChoice == 4) {
					System.out.print("Enter index of Pokemon to release: ");
					try {
						int index = Integer.parseInt(scanner.nextLine());
						player.removePokemon(index);
					} catch (NumberFormatException e) {
						System.out.println("Invalid input.");
					}
				}
				continue;
			}

			Leader gymLeader;
			City targetCity;
			Gym targetGym;
			Trainer rivalTrainer;

			if (menuChoice == 1) {
				gymLeader = new Leader("Brock", "Boulder");
				targetCity = new City("Pewter City", gymLeader);
				targetGym = new Gym("Pewter Gym", gymLeader);
				rivalTrainer = new Trainer("Gym Leader Brock");

				Pokemon geodude = new Snorlax("Geodude", 12, 40, 20, 25);
				geodude.setMove(0, tackle);
				geodude.setMove(1, new Move("Rock Throw", 13, 15));
				Pokemon onix = new Machamp("Onix", 14, 45, 24, 28);
				onix.setMove(0, tackle);
				onix.setMove(1, new Move("Rock Tomb", 15, 10));

				try {
					rivalTrainer.addPokemon(geodude);
					rivalTrainer.addPokemon(onix);
				} catch (Exception e) {
				}
			} else if (menuChoice == 2) {
				gymLeader = new Leader("Misty", "Cascade");
				targetCity = new City("Cerulean City", gymLeader);
				targetGym = new Gym("Cerulean Gym", gymLeader);
				rivalTrainer = new Trainer("Gym Leader Misty");

				Pokemon staryu = new Squirtle("Staryu", 18, 50, 22, 20);
				staryu.setMove(0, tackle);
				staryu.setMove(1, new Move("Water Pulse", 14, 20));
				Pokemon starmie = new Pidgey("Starmie", 21, 55, 26, 22);
				starmie.setMove(0, tackle);
				starmie.setMove(1, new Move("Bubblebeam", 16, 20));

				try {
					rivalTrainer.addPokemon(staryu);
					rivalTrainer.addPokemon(starmie);
				} catch (Exception e) {
				}
			} else if (menuChoice == 3) {
				gymLeader = new Leader("Lt. Surge", "Thunder");
				targetCity = new City("Vermilion City", gymLeader);
				targetGym = new Gym("Vermilion Gym", gymLeader);
				rivalTrainer = new Trainer("Gym Leader Lt. Surge");

				Pokemon voltorb = new Pikachu("Voltorb", 22, 52, 25, 18);
				voltorb.setMove(0, tackle);
				voltorb.setMove(1, new Move("Shock Wave", 14, 20));
				Pokemon raichu = new Pikachu("Raichu", 24, 65, 32, 22);
				raichu.setMove(0, tackle);
				raichu.setMove(1, new Move("Thunderbolt", 18, 15));

				try {
					rivalTrainer.addPokemon(voltorb);
					rivalTrainer.addPokemon(raichu);
				} catch (Exception e) {
				}
			} else {
				gymLeader = new Leader("Sabrina", "Marsh");
				targetCity = new City("Saffron City", gymLeader);
				targetGym = new Gym("Saffron Gym", gymLeader);
				rivalTrainer = new Trainer("Gym Leader Sabrina");

				Pokemon kadabra = new Mewtwo("Kadabra", 36, 80, 45, 30);
				kadabra.setMove(0, tackle);
				kadabra.setMove(1, confusion);
				Pokemon alakazam = new Mewtwo("Alakazam", 38, 95, 55, 38);
				alakazam.setMove(0, tackle);
				alakazam.setMove(1, new Move("Psychic", 19, 10));

				try {
					rivalTrainer.addPokemon(kadabra);
					rivalTrainer.addPokemon(alakazam);
				} catch (Exception e) {
				}
			}

			System.out.println("\nYou traveled to " + targetCity.getName());
			gymLeader.interact();
			targetGym.addChallenger(player);

			System.out.print("\nDo you want to challenge the gym now? (yes/no): ");
			String challengeConfirm = scanner.nextLine();

			if (challengeConfirm.equalsIgnoreCase("yes")) {
				targetGym.startCombat();
				Combat combatSession = new Combat(random.nextInt(1000), player, rivalTrainer);

				boolean combatActive = true;
				while (combatActive) {
					Pokemon playerActive = player.getActivePokemon();
					Pokemon rivalActive = rivalTrainer.getActivePokemon();

					if (playerActive == null) {
						System.out.println("\nAll your Pokemon are fainted! You lost the battle.");
						combatActive = false;
						break;
					}
					if (rivalActive == null) {
						System.out.println("\nYou defeated " + rivalTrainer.getName() + "!");
						gymLeader.rewardBadge(player);
						playerActive.gainXp(100 + random.nextInt(50));
						combatActive = false;
						break;
					}

					System.out.println("\n---------------------------------");
					System.out.println("YOUR POKEMON: " + playerActive.getName() + " (" + playerActive.getHp() + "/"
							+ playerActive.getMaxHp() + " HP)");
					System.out.println("RIVAL POKEMON: " + rivalActive.getName() + " (" + rivalActive.getHp() + "/"
							+ rivalActive.getMaxHp() + " HP)");
					System.out.println("---------------------------------");
					System.out.println("What will you do?");
					System.out.println("1. Attack");
					System.out.println("2. Use Potion");

					int action = -1;
					while (true) {
						System.out.print("Action: ");
						try {
							action = Integer.parseInt(scanner.nextLine());
							if (action == 1 || action == 2) {
								break;
							}
							System.out.println("Invalid choice. Please enter 1 or 2.");
						} catch (NumberFormatException e) {
							System.out.println("Invalid input. Please enter a valid number.");
						}
					}

					Pokemon rivalActiveBeforeTurn = rivalActive;

					if (action == 1) {
						System.out.println("Choose a move:");
						for (int i = 0; i < 4; i++) {
							Move m = playerActive.getMoves()[i];
							if (m != null) {
								System.out.println(
										i + ". " + m.getName() + " (PP: " + m.getPp() + "/" + m.getMaxPp() + ")");
							}
						}

						int moveIdx = -1;
						while (true) {
							System.out.print("Select move index: ");
							try {
								moveIdx = Integer.parseInt(scanner.nextLine());
								if (moveIdx >= 0 && moveIdx < 4 && playerActive.getMoves()[moveIdx] != null) {
									break;
								}
								System.out.println("Invalid choice. Please select a valid listed move.");
							} catch (NumberFormatException e) {
								System.out.println("Invalid input. Please enter a valid number.");
							}
						}

						combatSession.executeTurn(playerActive, rivalActiveBeforeTurn, moveIdx);
					} else {
						Potion p = new Potion();
						player.useItem(p, playerActive);
					}

					rivalActive = rivalTrainer.getActivePokemon();

					if (rivalActive != rivalActiveBeforeTurn) {
						if (rivalActive != null) {
							System.out.println("\n" + rivalActiveBeforeTurn.getName() + " fainted! "
									+ rivalTrainer.getName() + " sends out " + rivalActive.getName() + "!");
						} else {
							System.out.println("\n" + rivalActiveBeforeTurn.getName() + " fainted!");
						}
					} else if (rivalActive != null && playerActive.getHp() > 0) {
						System.out.println("\n[Rival Turn]");
						int rivalMoveIdx = (rivalActive.getMoves()[1] != null) ? 1 : 0;
						combatSession.executeTurn(rivalActive, playerActive, rivalMoveIdx);
					}
				}

				System.out.println("\nHeading to the local Pokemon Center to recover...");
				PokemonCenter center = new PokemonCenter(targetCity.getName() + " Pokemon Center");
				Nurse joy = new Nurse("Joy");
				joy.interact();
				joy.healTeam(player);
			} else {
				System.out.println("You decided to step back for now.");
			}
		}
		scanner.close();
	}
}