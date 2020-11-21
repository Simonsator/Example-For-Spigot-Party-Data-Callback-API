package de.simonsator.partyandfriends.apiexample;

import de.simonsator.partyandfriendsgui.api.datarequest.DataRequestPlayerInfo;
import de.simonsator.partyandfriendsgui.api.datarequest.party.PartyData;
import de.simonsator.partyandfriendsgui.api.datarequest.party.PartyDataCallBackRunnable;
import de.simonsator.partyandfriendsgui.api.datarequest.party.PartyDataRequestCallbackAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			PartyDataRequestCallbackAPI.getInstance().fetchPartyData((Player) sender, new PartyDataCallBackRunnable() {
				@Override
				public void onCallback(Player pPlayer, PartyData pParty, int pId) {
					if (pParty.DOES_EXIST) {
						DataRequestPlayerInfo leader = pParty.getPartyLeader();
						pPlayer.sendMessage("The party leaders name is " + leader.PLAYER_NAME + " and his uuid is " + leader.PLAYER_UUID + " and he is on the server " + leader.SERVER_NAME);
						pPlayer.sendMessage("The party contains the following party members:");
						for (DataRequestPlayerInfo partyMember : pParty.getPartyMembers())
							pPlayer.sendMessage("His name is " + partyMember.PLAYER_NAME + " and his uuid is " + partyMember.PLAYER_UUID + " and he is on the server " + partyMember.SERVER_NAME);
						pPlayer.sendMessage("Is this party public: " + pParty.getProperties().IS_PUBLIC);
					} else {
						pPlayer.sendMessage("You are not in a party");
					}
				}
			});
			return true;
		}
		return false;
	}
}
