/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.addon.ionic;

import java.io.FileNotFoundException;

import javax.ws.rs.Path;

import org.jboss.forge.addon.parser.java.resources.JavaResource;
import org.jboss.forge.addon.parser.java.resources.JavaResourceVisitor;
import org.jboss.forge.addon.resource.visit.VisitContext;
import org.jboss.forge.roaster.model.JavaClass;
import org.jboss.forge.roaster.model.source.JavaSource;

/**
 * A {@link JavaResourceVisitor} that inspects {@link JavaResource}s and verifies whether they are JAX-RS Resources that
 * employ the same conventions as the ones generated by the Forge REST plugin.
 */
class ResourcePathVisitor extends JavaResourceVisitor
{

   private String entityName;
   private String path = null;
   private boolean found = false;

   public ResourcePathVisitor(String entityName)
   {
      this.entityName = entityName;
   }

   @Override
   public void visit(VisitContext context, JavaResource javaResource)
   {
      if (!found)
      {
         try
         {
            JavaSource<?> javaSource = javaResource.getJavaType();
            if (javaSource instanceof JavaClass)
            {
               JavaClass<?> javaClass = (JavaClass<?>) javaSource;
               if (javaClass.getName().equals(entityName + "Endpoint") && javaClass.hasAnnotation(Path.class))
               {
                  this.path = javaClass.getAnnotation(Path.class).getStringValue();
                  found = true;
               }
            }
         }
         catch (FileNotFoundException e)
         {
            throw new RuntimeException(e);
         }
      }
   }

   public String getPath()
   {
      return path;
   }

}