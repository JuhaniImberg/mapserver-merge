/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package fi.kivibot.power.models.base;

import fi.kivibot.power.misc.PowerNetworkAccessTool;
import fi.paivola.mapserver.core.DataFrame;
import fi.paivola.mapserver.core.Event;
import fi.paivola.mapserver.core.GameManager;
import fi.paivola.mapserver.core.PointModel;
import fi.paivola.mapserver.core.setting.SettingMaster;

/**
 *
 * @author kivi
 */
public abstract class PowerUser extends PointModel {

    public PowerUser(int id) {
        super(id);
        this.name = "Power user";
    }

    @Override
    public void onTick(DataFrame last, DataFrame current) {
        //getPower(sort_loss(this.findSources()), last, this);
        this.saveDouble("power", PowerNetworkAccessTool.doPowerCalculations(this.getDouble("usage"), last, this));
    }

    @Override
    public void onEvent(Event e, DataFrame current) {
    }

    @Override
    public void onRegisteration(GameManager gm, SettingMaster sm) {
    }

    @Override
    public void onGenerateDefaults(DataFrame df) {
        this.saveDouble("power", 0);
        this.saveDouble("usage", 5);
    }

    @Override
    public void onUpdateSettings(SettingMaster sm) {
    }

    
}
