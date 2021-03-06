/*
 * Copyright (c) 2012, JFXtras
 *   All rights reserved.
 *
 *   Redistribution and use in source and binary forms, with or without
 *   modification, are permitted provided that the following conditions are met:
 *       * Redistributions of source code must retain the above copyright
 *         notice, this list of conditions and the following disclaimer.
 *       * Redistributions in binary form must reproduce the above copyright
 *         notice, this list of conditions and the following disclaimer in the
 *         documentation and/or other materials provided with the distribution.
 *       * Neither the name of the <organization> nor the
 *         names of its contributors may be used to endorse or promote products
 *         derived from this software without specific prior written permission.
 *
 *   THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *   ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *   WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *   DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 *   DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *   (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *   LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *   ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *   (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *   SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package jfxtras.labs.scene.control.gauge;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.ControlBuilder;
import javafx.util.Builder;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by
 * User: hansolo
 * Date: 27.07.12
 * Time: 17:10
 */
public class LinearScaleBuilder<B extends LinearScaleBuilder<B>> extends ControlBuilder<B> implements Builder<LinearScale> {
    private Map<String, Property> properties = new HashMap<String, Property>();


    // ******************** Constructors **************************************
    protected LinearScaleBuilder() {}


    // ******************** Methods *******************************************
    public static LinearScaleBuilder create() {
        return new LinearScaleBuilder();
    }

    public final LinearScaleBuilder minValue(final double MIN_VALUE) {
        properties.put("minValue", new SimpleDoubleProperty(MIN_VALUE));
        return this;
    }

    public final LinearScaleBuilder maxValue(final double MAX_VALUE) {
        properties.put("maxValue", new SimpleDoubleProperty(MAX_VALUE));
        return this;
    }

    public final LinearScaleBuilder niceScaling(final boolean NICE_SCALING) {
        properties.put("niceScaling", new SimpleBooleanProperty(NICE_SCALING));
        return this;
    }

    public final LinearScaleBuilder maxNoOfMajorTicks(final int MAX_NO_OF_MAJOR_TICKS) {
        properties.put("maxNoOfMajorTicks", new SimpleIntegerProperty(MAX_NO_OF_MAJOR_TICKS));
        return this;
    }

    public final LinearScaleBuilder maxNoOfMinorTicks(final int MAX_NO_OF_MINOR_TICKS) {
        properties.put("maxNoOfMinorTicks", new SimpleIntegerProperty(MAX_NO_OF_MINOR_TICKS));
        return this;
    }

    public final LinearScaleBuilder majorTickSpacing(final double MAJOR_TICK_SPACING) {
        properties.put("majorTickSpacing", new SimpleDoubleProperty(MAJOR_TICK_SPACING));
        return this;
    }

    public final LinearScaleBuilder minorTickSpacing(final double MINOR_TICK_SPACING) {
        properties.put("minorTickSpacing", new SimpleDoubleProperty(MINOR_TICK_SPACING));
        return this;
    }

    public final LinearScaleBuilder tightScale(final boolean TIGHT_SCALE) {
        properties.put("tightScale", new SimpleBooleanProperty(TIGHT_SCALE));
        return this;
    }

    public final LinearScaleBuilder largeNumberScale(final boolean LARGE_NUMBER_SCALE) {
        properties.put("largeNumberScale", new SimpleBooleanProperty(LARGE_NUMBER_SCALE));
        return this;
    }

    public LinearScale build() {
        final LinearScale CONTROL = new LinearScale();
        for (String key : properties.keySet()) {
            if ("minValue".equals(key)) {
                CONTROL.setMinValue(((DoubleProperty) properties.get(key)).get());
            } else if ("maxValue".equals(key)) {
                CONTROL.setMaxValue(((DoubleProperty) properties.get(key)).get());
            } else if ("niceScaling".equals(key)) {
                CONTROL.setNiceScaling(((BooleanProperty) properties.get(key)).get());
            } else if ("maxNoOfMajorTicks".equals(key)) {
                CONTROL.setMaxNoOfMajorTicks(((IntegerProperty) properties.get(key)).get());
            } else if ("maxNoOfMinorTicks".equals(key)) {
                CONTROL.setMaxNoOfMinorTicks(((IntegerProperty) properties.get(key)).get());
            } else if ("tightScale".equals(key)) {
                CONTROL.setTightScale(((BooleanProperty) properties.get(key)).get());
            } else if ("largeNumberScale".equals(key)) {
                CONTROL.setLargeNumberScale(((BooleanProperty) properties.get(key)).get());
            }
        }
        return CONTROL;
    }
}
