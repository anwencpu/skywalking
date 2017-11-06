/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.collector.core.graph;

import java.util.LinkedList;
import java.util.List;
import org.skywalking.apm.collector.core.framework.Executor;

/**
 * The <code>Next</code> is a delegate object for the following {@link Node}.
 *
 * @author peng-yongsheng, wu-sheng
 */
public class Next<Input> implements Executor<Input> {

    private final List<Node> nextNodes;

    public Next() {
        this.nextNodes = new LinkedList<>();
    }

    public final void addNext(Node node) {
        nextNodes.add(node);
    }

    /**
     * Drive to the next nodes
     *
     * @param input
     */
    @Override public void execute(Input input) {
        nextNodes.forEach(node -> node.execute(input));
    }
}