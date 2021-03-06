package fr.stan1712.seriousrp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Commands implements Listener{
    private Main pl;
  
    public Commands(Main pl) {
        this.pl = pl;
        pl.getConfig();
    }
    
    private static boolean isInt(String s) {
	    try {
			Integer.parseInt(s);
		}
	    catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	@EventHandler
	public void onCommandes(PlayerCommandPreprocessEvent e){
        Player player = e.getPlayer();
        String msg = e.getMessage();
        String[] args = msg.split(" ");
        
		// /seriousrp <version/help/status/reload>
		if(args[0].equalsIgnoreCase("/seriousrp") || args[0].equalsIgnoreCase("/srp")) {
			if(player.hasPermission("seriousrp.info")) {
				if(args.length == 2) {
					if(args[1].equalsIgnoreCase("version")) {
			            player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
			            player.sendMessage(ChatColor.GOLD + "» Version " + this.pl.getConfig().getString("Version").replace("&", "§"));
			            player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
					}
					else if(args[1].equalsIgnoreCase("help")) {
						player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
			            player.sendMessage(ChatColor.GOLD + "» /srtp = " + this.pl.getConfig().getString("Core.HelpMsg.Dsrtp").replace("&", "§"));
			            if(this.pl.getConfig().getBoolean("Core.Modules.TownSystem") == true) {
				            player.sendMessage(ChatColor.GOLD + "» /srtown = " + this.pl.getConfig().getString("Core.HelpMsg.DTown").replace("&", "§"));
				            player.sendMessage(ChatColor.GOLD + "» /srtown set = " + this.pl.getConfig().getString("Core.HelpMsg.DTownSet").replace("&", "§"));
				            player.sendMessage(ChatColor.GOLD + "» /srtown where = " + this.pl.getConfig().getString("Core.HelpMsg.DTownWhere").replace("&", "§"));
			            }
			            if(this.pl.getConfig().getBoolean("Core.Modules.Medics") == true) {
				            player.sendMessage(ChatColor.GOLD + "» /medinfo <player> = " + this.pl.getConfig().getString("Core.HelpMsg.DMedinfo").replace("&", "§"));
				            player.sendMessage(ChatColor.GOLD + "» /revive <player> = " + this.pl.getConfig().getString("Core.HelpMsg.DRevive").replace("&", "§"));
				            player.sendMessage(ChatColor.GOLD + "» /hrprevive = " + this.pl.getConfig().getString("Core.HelpMsg.DHRPRevive").replace("&", "§"));
			            }
			            if(this.pl.getConfig().getBoolean("Core.Modules.Economy") == true) {
				            player.sendMessage(ChatColor.GOLD + "» /cheque <amount> = " + this.pl.getConfig().getString("Core.HelpMsg.DCheque").replace("&", "§"));
			            }
			            player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
			            player.sendMessage(ChatColor.GOLD + "» /seriousrp help = " + this.pl.getConfig().getString("Core.HelpMsg.DVersion").replace("&", "§"));
			            player.sendMessage(ChatColor.GOLD + "» /seriousrp version = " + this.pl.getConfig().getString("Core.HelpMsg.DHelp").replace("&", "§"));
			            player.sendMessage(ChatColor.GOLD + "» /seriousrp status = " + this.pl.getConfig().getString("Core.HelpMsg.DStatus").replace("&", "§"));
			            player.sendMessage(ChatColor.GOLD + "» /seriousrp reload = " + this.pl.getConfig().getString("Core.HelpMsg.DReload").replace("&", "§"));
			            player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
					}
					else if(args[1].equalsIgnoreCase("status")) {
						player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
						if(this.pl.getConfig().getBoolean("Core.Modules.CustomRecipes") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "CustomRecipes > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "CustomRecipes > OFF");
						}
						if(this.pl.getConfig().getBoolean("Core.Modules.RPDeath") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "RPDeath > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "RPDeath > OFF");
						}
						if(this.pl.getConfig().getBoolean("Core.Modules.Medics") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "Medics > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "Medics > OFF");
						}
						if(this.pl.getConfig().getBoolean("Core.Modules.TownSystem") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "TownSystem > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "TownSystem > OFF");
						}
						/*if(this.pl.getConfig().getBoolean("Core.Modules.RPMobiles") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "RPMobiles > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "RPMobiles > OFF");
						}*/
						if(this.pl.getConfig().getBoolean("Core.Modules.Chairs") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "Chairs > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "Chairs > OFF");
						}
						if(this.pl.getConfig().getBoolean("Core.Modules.Economy") == true) {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.GREEN + "Economy > ON");
						}
						else {
							player.sendMessage(ChatColor.GOLD + "» " + ChatColor.RED + "Economy > OFF");
						}
			            player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
					}
					else if(args[1].equalsIgnoreCase("reload")) {
						if(player.hasPermission("seriousrp.admin.reload")) {							
							new Config();
				            this.pl.saveConfig();
				               
							player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
				            player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.Reload").replace("&", "§"));
				            player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
						}
						else {
							player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
						}
					}
				}
				else {
					player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.HelpMsg.Help").replace("&", "§"));
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.HelpMsg.VersionHelp").replace("&", "§"));
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.HelpMsg.StatusHelp").replace("&", "§"));
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.HelpMsg.ReloadHelp").replace("&", "§"));
					player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
				}
			}
			else {
				player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
			}
		}
		
		// /srtp
		if(args[0].equalsIgnoreCase("/srtp")) {
			if(player.hasPermission("serious.randomtp")) {
				Random r = new Random();
				
				player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
				player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("MicroModules.RandomTeleport").replace("&", "§"));
				player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 50, 100));
				player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 50, 100));
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 50, 100));
				
				int x = ((Player) player).getLocation().getBlockX() + r.nextInt(this.pl.getConfig().getInt("MicroModules.RandomBlocks"));
				int z = ((Player) player).getLocation().getBlockX() + r.nextInt(this.pl.getConfig().getInt("MicroModules.RandomBlocks"));
				
				int rtpcheck = ((Player) player).getWorld().getHighestBlockYAt(x, z);
				int rtpdone = rtpcheck + 1;
				
				Location rtp = new Location(((Player) player).getWorld(), x, rtpdone, z);
				((Player) player).teleport(rtp);
			}
			else {
				player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
			}
		}
		
		// /srtown <set/where>
		
		if(args[0].equalsIgnoreCase("/srtown")) {
			if(this.pl.getConfig().getBoolean("Core.Modules.TownSystem") == true) {
				double x = this.pl.getConfig().getDouble("TownSystem.Locations.Town.x");
				double y = this.pl.getConfig().getDouble("TownSystem.Locations.Town.y");
				double z = this.pl.getConfig().getDouble("TownSystem.Locations.Town.z");
				String monde = this.pl.getConfig().getString("TownSystem.Locations.Town.WorldName");
				World world = Bukkit.getWorld(monde);
				
				if(player.hasPermission("seriousrp.town")) {
					if(args.length == 2) {
						if(args[1].equalsIgnoreCase("set")) {
							if(player.hasPermission("seriousrp.townset")) {
								this.pl.getConfig().set("TownSystem.Locations.Town.x", Integer.valueOf(((Player) player).getLocation().getBlockX()));
								this.pl.getConfig().set("TownSystem.Locations.Town.y", Integer.valueOf(((Player) player).getLocation().getBlockY()));
								this.pl.getConfig().set("TownSystem.Locations.Town.z", Integer.valueOf(((Player) player).getLocation().getBlockZ()));
								this.pl.getConfig().set("TownSystem.Locations.Town.WorldName", ((Player) player).getWorld().getName());
								this.pl.saveConfig();
								
								player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
								player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("TownSystem.Teleports.SetTown").replace("&", "§"));
								player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
							}
							else {
								player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
							}
						}
						else if(args[1].equalsIgnoreCase("where")) {
							player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
							player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("TownSystem.Teleports.TownWhere").replace("&", "§") + " x" + x + ", y" + y + ", z" + z);
							player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
						}
						else if(args[1].equalsIgnoreCase("tp")) {
							player.teleport(new Location(world, x, y, z));
							
							player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
							player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("TownSystem.Teleports.GoToTown").replace("&", "§"));
							player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
						}
					}
					else {
						player.teleport(new Location(world, x, y, z));
						
						player.sendMessage(ChatColor.AQUA + "+----- ♖ " + this.pl.getConfig().getString("Prefix").replace("&", "§") + " ♖ -----+");
						player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("TownSystem.Teleports.GoToTown").replace("&", "§"));
						player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
					}
				}
				else {
					player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
				}
			}
			else {
				if(this.pl.getConfig().getBoolean("Core.Modules.InactiveDebug")) {
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.Modules.InactiveMessage").replace("&", "§").replace("%module%", "TownSystem"));
				}
			}
		}
		
		// /revive
		if(args[0].equalsIgnoreCase("/revive")) {
			if(this.pl.getConfig().getBoolean("Core.Modules.Medics") == true) {
				if(player.hasPermission("seriousrp.medrevive")) {
					Player cible = Bukkit.getPlayer(args[1]);
					if(cible != null) {
						if(cible.getHealth() < 10.0D) {
							cible.setHealth(20.0D);
							player.sendMessage(this.pl.getConfig().getString("Medics.MedRevive.Revive").replace("&", "§") + " " + args[1]);
							
							cible.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							cible.removePotionEffect(PotionEffectType.SLOW);
							cible.removePotionEffect(PotionEffectType.BLINDNESS);
							cible.removePotionEffect(PotionEffectType.HUNGER);
							cible.removePotionEffect(PotionEffectType.JUMP);
							cible.setFoodLevel(10);
						}
						else {
							player.sendMessage(this.pl.getConfig().getString("Medics.MedRevive.NoNeed").replace("&", "§"));
						}
					}
					else {
						player.sendMessage(ChatColor.DARK_RED + args[1] + " " + this.pl.getConfig().getString("Medics.MedRevive.Error").replace("&", "§"));
					}
				}
				else {
					player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
				}
			}
			else {
				if(this.pl.getConfig().getBoolean("Core.Modules.InactiveDebug")) {
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.Modules.InactiveMessage").replace("&", "§").replace("%module%", "Medics"));
				}
			}
		}
		// /hrprevive
		if(args[0].equalsIgnoreCase("/hrprevive")) {
			if(this.pl.getConfig().getBoolean("Core.Modules.Medics") == true) {
				if(player.hasPermission("seriousrp.medhrprevive")) {
					if(player.getHealth() < 10.0D) {
						player.sendMessage(this.pl.getConfig().getString("Medics.MedRevive.Self").replace("&", "§"));
						
						 player.setHealth(20);
	
	                     player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
	                     player.removePotionEffect(PotionEffectType.SLOW);
	                     player.removePotionEffect(PotionEffectType.BLINDNESS);
	                     player.removePotionEffect(PotionEffectType.HUNGER);
	                     player.removePotionEffect(PotionEffectType.JUMP);
	
	                     player.setFoodLevel(10);
					}
					else {
						player.sendMessage(this.pl.getConfig().getString("Medics.MedRevive.NoNeed").replace("&", "§"));
					}
				}
				else {
					player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
				}
			}
			else {
				if(this.pl.getConfig().getBoolean("Core.Modules.InactiveDebug")) {
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.Modules.InactiveMessage").replace("&", "§").replace("%module%", "Medics"));
				}
			}
		}
		// /medinfo
		if(args[0].equalsIgnoreCase("/medinfo")) {
			if(this.pl.getConfig().getBoolean("Core.Modules.Medics") == true) {
				if(player.hasPermission("seriousrp.medinfo")) {
					Player cible = Bukkit.getPlayer(args[1]);
					if (cible != null) {
						double vie = cible.getHealth();
						double faim = cible.getFoodLevel();
						    
						Collection<PotionEffect> effects = cible.getActivePotionEffects();
						    
						int x = Integer.valueOf(cible.getLocation().getBlockX()).intValue();
						int y = Integer.valueOf(cible.getLocation().getBlockY()).intValue();
						int z = Integer.valueOf(cible.getLocation().getBlockZ()).intValue();
						String monde = cible.getWorld().getName();
						    
						player.sendMessage(ChatColor.AQUA + "+----- ♖ " + args[1] + " ♖ -----+");
						if (vie > 10.0D) {
							player.sendMessage("§a" + this.pl.getConfig().getString("Medics.MedInfo.Health").replace("&", "§") + " " + vie / 2.0D + " " + this.pl.getConfig().getString("Medics.MedInfo.Hearts").replace("&", "§"));
						}
						else if (vie <= 9.0D) {
							player.sendMessage("§c" + this.pl.getConfig().getString("Medics.MedInfo.Health").replace("&", "§") + " " + vie / 2.0D + " " + this.pl.getConfig().getString("Medics.MedInfo.Hearts").replace("&", "§"));
						}
						if (faim > 10.0D) {
							player.sendMessage("§a" + this.pl.getConfig().getString("Medics.MedInfo.Food").replace("&", "§") + " " + faim / 2.0D + " / 10");
						}
						else if (faim <= 9.0D) {
							player.sendMessage("§c" + this.pl.getConfig().getString("Medics.MedInfo.Food").replace("&", "§") + " " + faim / 2.0D + " / 10");
						}
						
						player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
						player.sendMessage("§a" + this.pl.getConfig().getString("Medics.MedInfo.Effects").replace("&", "§") + " " + effects);
						player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
						player.sendMessage("§a" + args[1] + " " + this.pl.getConfig().getString("Medics.MedInfo.Coordinates").replace("&", "§") + " " + x + ", " + y + ", " + z + " > " + monde);
						player.sendMessage(ChatColor.AQUA + "+----- ----- ----- -----+");
					}
					else {
						player.sendMessage(ChatColor.DARK_RED + args[1] + " " + this.pl.getConfig().getString("Medic.Error").replace("&", "§"));
					}
					
				}
				else {
					player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
				}
			}
			else {
				if(this.pl.getConfig().getBoolean("Core.Modules.InactiveDebug")) {
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.Modules.InactiveMessage").replace("&", "§").replace("%module%", "Medics"));
				}
			}
		}
		
		// /srtp
		if(args[0].equalsIgnoreCase("/cheque") || args[0].equalsIgnoreCase("/cq")) {
			if(this.pl.getConfig().getBoolean("Core.Modules.Economy") == true) {
				if(player.hasPermission("seriousrp.economy.cheques")) {
					if(args.length == 2 && isInt(args[1])) {
						ItemStack inHand = new ItemStack(Material.PAPER);
						ItemMeta inHandMeta = inHand.getItemMeta();
						ArrayList<String> inHandLore = new ArrayList<String>();
						inHandMeta.setDisplayName(this.pl.getConfig().getString("Economy.Cheque.Lores.Title").replace("&", "§").replace("%amount%", args[1]));
						inHandLore.add(this.pl.getConfig().getString("Economy.Cheque.Lores.Value").replace("&", "§") + "§l" + args[1] + this.pl.getConfig().getString("Economy.Currency"));
						inHandLore.add(this.pl.getConfig().getString("Economy.Cheque.Lores.Author").replace("&", "§") + "§7§o" + player.getDisplayName());
						inHandLore.add("");
						inHandLore.add(this.pl.getConfig().getString("Economy.Cheque.Lores.Usage").replace("&", "§"));
						inHandMeta.setLore(inHandLore);
						inHand.setItemMeta(inHandMeta);
						
						if (player.getInventory().contains(inHand)) {
							player.sendMessage(this.pl.getConfig().getString("Economy.Cheque.Already").replace("&", "§").replace("%amount%", args[1]));
						}
						else {
							String price = args[1];
							double dprice = Double.valueOf(price).doubleValue();
							
							if (Main.economy.getBalance(player) < dprice) {
								player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Economy.NotEnough").replace("&", "§").replace("%amount%", args[1]));
							}
							else {
								player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Economy.Cheque.Created").replace("&", "§").replace("%amount%", args[1]));
								Main.economy.withdrawPlayer(player, dprice);
								player.getInventory().addItem(inHand);
							}
						}
					}
					else {
						player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Economy.Cheque.Usage").replace("&", "§"));
					}
					
				}
				else {
					player.sendMessage("[" + this.pl.getConfig().getString("Prefix").replace("&", "§") + "]" + this.pl.getConfig().getString("Core.NoPerms").replace("&", "§"));
				}
			}
			else {
				if(this.pl.getConfig().getBoolean("Core.Modules.InactiveDebug")) {
					player.sendMessage(ChatColor.GOLD + "» " + this.pl.getConfig().getString("Core.Modules.InactiveMessage").replace("&", "§").replace("%module%", "Economy"));
				}
			}
		}
		
	}
}
