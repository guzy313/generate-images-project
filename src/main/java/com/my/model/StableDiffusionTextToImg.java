package com.my.model;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/11/17
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StableDiffusionTextToImg implements Serializable{


        /**
         * 去噪强度
         */
        private Integer denoising_strength;
        private Integer firstphase_width;
        private Integer firstphase_height;

        /**
         * 高清修复
         * 缩写hr代表的就是webui中的"高分辨率修复 (Hires. fix)"，相关的参数对应的是webui中的这些选项：
         */
        private Boolean enable_hr;
        /**
         * default 2
         */
        private Integer hr_scale;
        private String hr_upscaler;
        private Integer hr_second_pass_steps;
        private Integer hr_resize_x;
        private Integer hr_resize_y;
        private String hr_sampler_name;
        private String hr_prompt;
        private String hr_negative_prompt;

        /**
         * 正向提示词, 默认 ""
         * lora 需要放在 prompt 里
         */
        private String prompt;

        /**
         * 反向提示词, 默认 ""
         */
        private String negative_prompt;

        private List<String> styles;

        /**
         * 随机数种子 (Seed)
         */
        private Integer seed;

        private Integer clip_skip;


        /**
         *
         */
        private Integer subseed;

        /**
         *
         */
        private Integer subseed_strength;

        /**
         * 高度
         */
        private Integer seed_resize_from_h;

        /**
         * 宽度
         */
        private Integer seed_resize_from_w;


        /**
         * 采样方法 (Sampler), 默认 null
         */
        private String sampler_name;

        /**
         * 采样方法 (Sampler) 下标
         */
        private String sampler_index;

        /**
         * 批次数 default: 1
         */
        private Integer batch_size;

        /**
         * 每批的数量 default: 1
         */
        private Integer n_iter;

        /**
         * 迭代步数 (Steps), 默认 50
         */
        private Integer steps;

        /**
         * 提示词引导系数, 默认7
         */
        private Double cfg_scale;

        /**
         * 宽度
         */
        private Integer width;

        /**
         * 高度
         */
        private Integer height;

        /**
         * 面部修复, 默认 false
         */
        private Boolean restore_faces;

        /**
         * 平铺图 默认 false
         */
        private Boolean tiling;

        /**
         * 默认 false
         */
        private Boolean do_not_save_samples;

        /**
         * 默认 false
         */
        private Boolean do_not_save_grid;

        /**
         * 默认 null
         */
        private Integer eta;

        /**
         * 默认 0
         */
        private Integer s_min_uncond;

        /**
         * 默认 0
         */
        private Integer s_churn;

        /**
         * 默认 null
         */
        private Integer s_tmax;

        /**
         * 默认 0
         */
        private Integer s_tmin;

        /**
         * 默认 1
         */
        private Integer s_noise;

        /**
         * 默认 null
         */
        private OverrideSettings override_settings;

        /**
         * 默认 true
         */
        private Boolean override_settings_restore_afterwards;


        private List<Object> script_args;

        /**
         * 默认 null
         */
        private String script_name;

        /**
         * 默认 true
         */
        private Boolean send_images;

        /**
         * 默认 false
         */
        private Boolean save_images;

        /**
         * 默认 {}
         */
        private AlwaysonScripts alwayson_scripts;

        public Integer getDenoising_strength() {
                return denoising_strength;
        }

        public void setDenoising_strength(Integer denoising_strength) {
                this.denoising_strength = denoising_strength;
        }

        public Integer getFirstphase_width() {
                return firstphase_width;
        }

        public void setFirstphase_width(Integer firstphase_width) {
                this.firstphase_width = firstphase_width;
        }

        public Integer getFirstphase_height() {
                return firstphase_height;
        }

        public void setFirstphase_height(Integer firstphase_height) {
                this.firstphase_height = firstphase_height;
        }

        public Boolean getEnable_hr() {
                return enable_hr;
        }

        public void setEnable_hr(Boolean enable_hr) {
                this.enable_hr = enable_hr;
        }

        public Integer getHr_scale() {
                return hr_scale;
        }

        public void setHr_scale(Integer hr_scale) {
                this.hr_scale = hr_scale;
        }

        public String getHr_upscaler() {
                return hr_upscaler;
        }

        public void setHr_upscaler(String hr_upscaler) {
                this.hr_upscaler = hr_upscaler;
        }

        public Integer getHr_second_pass_steps() {
                return hr_second_pass_steps;
        }

        public void setHr_second_pass_steps(Integer hr_second_pass_steps) {
                this.hr_second_pass_steps = hr_second_pass_steps;
        }

        public Integer getHr_resize_x() {
                return hr_resize_x;
        }

        public void setHr_resize_x(Integer hr_resize_x) {
                this.hr_resize_x = hr_resize_x;
        }

        public Integer getHr_resize_y() {
                return hr_resize_y;
        }

        public void setHr_resize_y(Integer hr_resize_y) {
                this.hr_resize_y = hr_resize_y;
        }

        public String getHr_sampler_name() {
                return hr_sampler_name;
        }

        public void setHr_sampler_name(String hr_sampler_name) {
                this.hr_sampler_name = hr_sampler_name;
        }

        public String getHr_prompt() {
                return hr_prompt;
        }

        public void setHr_prompt(String hr_prompt) {
                this.hr_prompt = hr_prompt;
        }

        public String getHr_negative_prompt() {
                return hr_negative_prompt;
        }

        public void setHr_negative_prompt(String hr_negative_prompt) {
                this.hr_negative_prompt = hr_negative_prompt;
        }

        public String getPrompt() {
                return prompt;
        }

        public void setPrompt(String prompt) {
                this.prompt = prompt;
        }

        public String getNegative_prompt() {
                return negative_prompt;
        }

        public void setNegative_prompt(String negative_prompt) {
                this.negative_prompt = negative_prompt;
        }

        public List<String> getStyles() {
                return styles;
        }

        public void setStyles(List<String> styles) {
                this.styles = styles;
        }

        public Integer getSeed() {
                return seed;
        }

        public void setSeed(Integer seed) {
                this.seed = seed;
        }

        public Integer getClip_skip() {
                return clip_skip;
        }

        public void setClip_skip(Integer clip_skip) {
                this.clip_skip = clip_skip;
        }

        public Integer getSubseed() {
                return subseed;
        }

        public void setSubseed(Integer subseed) {
                this.subseed = subseed;
        }

        public Integer getSubseed_strength() {
                return subseed_strength;
        }

        public void setSubseed_strength(Integer subseed_strength) {
                this.subseed_strength = subseed_strength;
        }

        public Integer getSeed_resize_from_h() {
                return seed_resize_from_h;
        }

        public void setSeed_resize_from_h(Integer seed_resize_from_h) {
                this.seed_resize_from_h = seed_resize_from_h;
        }

        public Integer getSeed_resize_from_w() {
                return seed_resize_from_w;
        }

        public void setSeed_resize_from_w(Integer seed_resize_from_w) {
                this.seed_resize_from_w = seed_resize_from_w;
        }

        public String getSampler_name() {
                return sampler_name;
        }

        public void setSampler_name(String sampler_name) {
                this.sampler_name = sampler_name;
        }

        public String getSampler_index() {
                return sampler_index;
        }

        public void setSampler_index(String sampler_index) {
                this.sampler_index = sampler_index;
        }

        public Integer getBatch_size() {
                return batch_size;
        }

        public void setBatch_size(Integer batch_size) {
                this.batch_size = batch_size;
        }

        public Integer getN_iter() {
                return n_iter;
        }

        public void setN_iter(Integer n_iter) {
                this.n_iter = n_iter;
        }

        public Integer getSteps() {
                return steps;
        }

        public void setSteps(Integer steps) {
                this.steps = steps;
        }

        public Double getCfg_scale() {
                return cfg_scale;
        }

        public void setCfg_scale(Double cfg_scale) {
                this.cfg_scale = cfg_scale;
        }

        public Integer getWidth() {
                return width;
        }

        public void setWidth(Integer width) {
                this.width = width;
        }

        public Integer getHeight() {
                return height;
        }

        public void setHeight(Integer height) {
                this.height = height;
        }

        public Boolean getRestore_faces() {
                return restore_faces;
        }

        public void setRestore_faces(Boolean restore_faces) {
                this.restore_faces = restore_faces;
        }

        public Boolean getTiling() {
                return tiling;
        }

        public void setTiling(Boolean tiling) {
                this.tiling = tiling;
        }

        public Boolean getDo_not_save_samples() {
                return do_not_save_samples;
        }

        public void setDo_not_save_samples(Boolean do_not_save_samples) {
                this.do_not_save_samples = do_not_save_samples;
        }

        public Boolean getDo_not_save_grid() {
                return do_not_save_grid;
        }

        public void setDo_not_save_grid(Boolean do_not_save_grid) {
                this.do_not_save_grid = do_not_save_grid;
        }

        public Integer getEta() {
                return eta;
        }

        public void setEta(Integer eta) {
                this.eta = eta;
        }

        public Integer getS_min_uncond() {
                return s_min_uncond;
        }

        public void setS_min_uncond(Integer s_min_uncond) {
                this.s_min_uncond = s_min_uncond;
        }

        public Integer getS_churn() {
                return s_churn;
        }

        public void setS_churn(Integer s_churn) {
                this.s_churn = s_churn;
        }

        public Integer getS_tmax() {
                return s_tmax;
        }

        public void setS_tmax(Integer s_tmax) {
                this.s_tmax = s_tmax;
        }

        public Integer getS_tmin() {
                return s_tmin;
        }

        public void setS_tmin(Integer s_tmin) {
                this.s_tmin = s_tmin;
        }

        public Integer getS_noise() {
                return s_noise;
        }

        public void setS_noise(Integer s_noise) {
                this.s_noise = s_noise;
        }

        public OverrideSettings getOverride_settings() {
                return override_settings;
        }

        public void setOverride_settings(OverrideSettings override_settings) {
                this.override_settings = override_settings;
        }

        public Boolean getOverride_settings_restore_afterwards() {
                return override_settings_restore_afterwards;
        }

        public void setOverride_settings_restore_afterwards(Boolean override_settings_restore_afterwards) {
                this.override_settings_restore_afterwards = override_settings_restore_afterwards;
        }

        public List<Object> getScript_args() {
                return script_args;
        }

        public void setScript_args(List<Object> script_args) {
                this.script_args = script_args;
        }

        public String getScript_name() {
                return script_name;
        }

        public void setScript_name(String script_name) {
                this.script_name = script_name;
        }

        public Boolean getSend_images() {
                return send_images;
        }

        public void setSend_images(Boolean send_images) {
                this.send_images = send_images;
        }

        public Boolean getSave_images() {
                return save_images;
        }

        public void setSave_images(Boolean save_images) {
                this.save_images = save_images;
        }

        public AlwaysonScripts getAlwayson_scripts() {
                return alwayson_scripts;
        }

        public void setAlwayson_scripts(AlwaysonScripts alwayson_scripts) {
                this.alwayson_scripts = alwayson_scripts;
        }
}
