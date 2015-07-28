/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.impl.scripting;

import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.scriptengine.DmnCompiledScript;
import org.camunda.bpm.engine.delegate.Expression;
import org.camunda.bpm.engine.repository.DecisionDefinition;

/**
 * <p>A script factory is responsible for creating a {@link ExecutableScript}
 * instance. Users may customize (subclass) this class in order to customize script
 * creation. For instance, some users may choose to pre-process scripts before
 * they are created.</p>
 *
 * @author Daniel Meyer
 *
 */
public class ScriptFactory {

  public ExecutableScript createScriptFromResource(String language, String resource) {
    return new ResourceExecutableScript(language, resource);
  }

  public ExecutableScript createScriptFromResource(String language, Expression resourceExpression) {
    return new DynamicResourceExecutableScript(language, resourceExpression);
  }

  public ExecutableScript createScriptFromSource(String language, String source) {
    return new SourceExecutableScript(language, source);
  }

  public ExecutableScript createScriptFromSource(String language, Expression sourceExpression) {
    return new DynamicSourceExecutableScript(language, sourceExpression);
  }

  public ExecutableScript createScriptFromDecisionDefinition(DecisionDefinition definition) {
    return new DmnExecutableScript((DmnDecision) definition);
  }

}
