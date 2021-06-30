/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.axolotl;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.Server;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Axolotl.Variant;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;

/**
 *
 * @author Wtnaut
 */
public class AxolotlListener implements Listener{
    private final boolean debug = false;
    private Server serv;
    AxolotlListener(Server input){
    this.serv=input;
    }
    @EventHandler
    public void checkAxolotl(EntityBreedEvent event){
        if(event.getEntityType().equals(EntityType.AXOLOTL)) {
            if(((Axolotl)event.getMother()).getVariant().equals(Variant.BLUE)||((Axolotl)event.getFather()).getVariant().equals(Variant.BLUE)){
                if(((Axolotl)event.getEntity()).getVariant().equals(Variant.BLUE)){
                    if(debug)
                    this.serv.broadcastMessage("debug:AxolotlDetected");
                int x = (int)(1+Math.random()*1200);
                if(x!=0)
                {
                    if(!((Axolotl)event.getMother()).getVariant().equals(Variant.BLUE))
                        ((Axolotl)event.getEntity()).setVariant(((Axolotl)event.getMother()).getVariant());
                    else if(!((Axolotl)event.getFather()).getVariant().equals(Variant.BLUE))
                        ((Axolotl)event.getEntity()).setVariant(((Axolotl)event.getFather()).getVariant());
                    else{
                        if(debug)
                            this.serv.broadcastMessage("debug:TwoBlueAxolotlsDetected");
                       switch((int)(Math.random()*4)){
                           case 0:
                            ((Axolotl)event.getEntity()).setVariant(Variant.GOLD);
                            break;
                           case 1:
                             ((Axolotl)event.getEntity()).setVariant(Variant.LUCY);
                            break;
                           case 2:
                             ((Axolotl)event.getEntity()).setVariant(Variant.CYAN);
                            break;
                           case 3:
                             ((Axolotl)event.getEntity()).setVariant(Variant.WILD);
                            break;
                       }
                    }
                }
                }
            }
        }
    }//check Axolotl

}
