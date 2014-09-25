/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.forge.addon.ionic;

import static org.jboss.forge.addon.ionic.AngularScaffoldProvider.SCAFFOLD_DIR;

import java.util.ArrayList;
import java.util.List;

/**
 * A collection of utility methods that return collections representing groups of {@link ScaffoldResource}s for further
 * processing.
 * 
 */
public class ResourceProvider {

    static final String INDEX_HTML = "/index.html";
    
    static final String CONFIG_XML = "/config.xml";
    
    static final String LANDING_VIEW = "/views/landing.html";



    static final String IONICONS_SVG = "/fonts/ionicons.svg";
    
    static final String IONICONS_TTF = "/fonts/ionicons.ttf";
    
    static final String IONICONS_WOFF = "/fonts/ionicons.woff";
    
    static final String ANGULAR_RESOURCE_JS = "/scripts/vendor/angular-resource.min.js";
    
    static final String IONIC_BUNDLE_JS = "/scripts/vendor/ionic.bundle.min.js";

    static final String MAIN_CSS = "/styles/style.css";
    
    static final String IONIC_CSS = "/styles/ionic.min.css";
    
    

    /**
     * Provides a list of {@link ScaffoldResource}s representing static files that are to be copied upon scaffolding setup.
     * 
     * @param targetDir The target directory that serves as the root directory of the destination for the generated resources to
     *        be copied to.
     * @param strategy The {@link ProcessingStrategy} to use for processing the static file. Usually this involves a strategy to copy
     *        files from a source to destination.
     * @return A list of {@link ScaffoldResource}s representing static files that are to be copied upon scaffolding setup.
     */
    public static List<ScaffoldResource> getStatics(String targetDir, ProcessingStrategy strategy) {
        List<ScaffoldResource> statics = new ArrayList<>();
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + IONIC_CSS, targetDir + IONIC_CSS, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + MAIN_CSS, targetDir + MAIN_CSS, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + IONIC_BUNDLE_JS, targetDir + IONIC_BUNDLE_JS, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + ANGULAR_RESOURCE_JS, targetDir + ANGULAR_RESOURCE_JS, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + IONICONS_SVG, targetDir + IONICONS_SVG, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + IONICONS_TTF, targetDir + IONICONS_TTF, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + IONICONS_WOFF, targetDir + IONICONS_WOFF, strategy));
        statics.add(new ScaffoldResource(SCAFFOLD_DIR + LANDING_VIEW, targetDir + LANDING_VIEW, strategy));
        return statics;
    }
    
    /**
     * Provides a list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed only once for a
     * scaffold generation run.
     * 
     * @param targetDir The target directory that serves as the root directory of the destination for the generated resources to
     *        be written to.
     * @param strategy The {@link ProcessingStrategy} to use for processing the static file. Usually this involves a strategy to process
     *        the file as a Freemarker template before copying it from a source to destination.
     * @return A list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed only once for a
     *         scaffold generation run.
     */
    public static List<ScaffoldResource> getGlobalTemplates(String targetDir, ProcessingStrategy strategy) {
        List<ScaffoldResource> resources = new ArrayList<>();
        resources.add(new ScaffoldResource("/config.xml.ftl", targetDir+ CONFIG_XML, strategy));
        resources.add(new ScaffoldResource("/index.html.ftl", targetDir+ INDEX_HTML, strategy));
        resources.add(new ScaffoldResource("/app.html.ftl", targetDir + "/app.html", strategy));
        resources.add(new ScaffoldResource("/views/tabs.html.ftl", targetDir + "/views/tabs.html", strategy));
        resources.add(new ScaffoldResource("/scripts/app.js.ftl", targetDir + "/scripts/app.js", strategy));
        resources.add(new ScaffoldResource("/scripts/directives/datepicker.js.ftl", targetDir
                + "/scripts/directives/datepicker.js", strategy));
        resources.add(new ScaffoldResource("/scripts/directives/timepicker.js.ftl", targetDir
                + "/scripts/directives/timepicker.js", strategy));
        resources.add(new ScaffoldResource("/scripts/directives/datetimepicker.js.ftl", targetDir
                + "/scripts/directives/datetimepicker.js", strategy));
        resources.add(new ScaffoldResource("/scripts/services/locationParser.js.ftl", targetDir
                + "/scripts/services/locationParser.js", strategy));
        resources.add(new ScaffoldResource("/scripts/filters/genericSearchFilter.js.ftl", targetDir
                + "/scripts/filters/genericSearchFilter.js", strategy));
        resources.add(new ScaffoldResource("/scripts/filters/startFromFilter.js.ftl", targetDir
                + "/scripts/filters/startFromFilter.js", strategy));
        return resources;
    }

    /**
     * Provides a list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed for every entity
     * during a scaffold generation run.
     * 
     * @param targetDir The target directory that serves as the root directory of the destination for the generated resources to
     *        be written to.
     * @param entityName The name of the JPA entity
     * @param strategy The {@link ProcessingStrategy} to use for processing the static file. Usually this involves a strategy to process
     *        the file as a Freemarker template before copying it from a source to destination.
     * @return A list of {@link ScaffoldResource}s representing Freemarker templates that are to be processed for every entity
     *         during a scaffold generation run.
     */
    public static List<ScaffoldResource> getEntityTemplates(String targetDir, String entityName, ProcessingStrategy strategy) {
        List<ScaffoldResource> resources = new ArrayList<>();
        resources.add(new ScaffoldResource("/scripts/services/entityFactory.js.ftl", targetDir + "/scripts/services/"
                + entityName + "Factory.js", strategy));
        resources.add(new ScaffoldResource("/scripts/controllers/newEntityController.js.ftl", targetDir
                + "/scripts/controllers/new" + entityName + "Controller.js", strategy));
        resources.add(new ScaffoldResource("/scripts/controllers/listEntityController.js.ftl", targetDir
                + "/scripts/controllers/list" + entityName + "Controller.js", strategy));
        resources.add(new ScaffoldResource("/scripts/controllers/editEntityController.js.ftl", targetDir
                + "/scripts/controllers/edit" + entityName + "Controller.js", strategy));
        return resources;
    }

}
