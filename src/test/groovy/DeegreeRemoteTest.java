import java.net.URI;

import eu.esdihumboldt.hale.common.instance.model.InstanceCollection;

/*
 * Copyright 2016 by it's authors.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution. If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Using a deegree remote API to store hale instances.
 *
 * @author Simon Templer
 */
public class DeegreeRemoteTest extends AbstractInstanceTest {

  @Override
  protected void handleInstances(InstanceCollection instances, URI schema) {
    // TODO spin up deegree and activate workspace (e.g. using Docker?)

    // TODO use deegree remote API (WFS-T, REST or ?) to store instances
  }

}
