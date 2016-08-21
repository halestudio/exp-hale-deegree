import java.net.URI;

import eu.esdihumboldt.hale.common.instance.model.Instance;
import eu.esdihumboldt.hale.common.instance.model.InstanceCollection;
import eu.esdihumboldt.hale.common.instance.model.ResourceIterator;

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
 * Using the deegree Java API to store hale instances.
 *
 * @author Simon Templer
 */
public class DeegreeAPITest extends AbstractInstanceTest {

  @Override
  protected void handleInstances(InstanceCollection instances, URI schema) {
    // TODO use deegree Java API to store instances

    //XXX just dummy code, remove me:
    int count = 0;
    if (instances.hasSize()) {
      count = instances.size();
    }
    else {
      try (ResourceIterator<Instance> it = instances.iterator()) {
        while (it.hasNext()) {
          it.next();
          count++;
        }
      }
    }
    System.out.println(count + " instances in data set");

  }

}
