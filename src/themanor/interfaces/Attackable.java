/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themanor.interfaces;

import themanor.Player;

/**
 *
 * @author alexa
 */
public interface Attackable {
    
    
    public void attacked(Player player, int damage_taken);
    
    public void attack(Player player, int damage);

    
    
}
