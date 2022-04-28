<template>
    <div class="column is-5" style="margin-bottom: 2rem;">
        <div class="columns box">
            <div class="column is-one-third">
                <figure class="image is-fullwidth">
                    <slot name="image">
                        <img src="~/assets/gfx_missing.png" alt="missing logo" />
                    </slot>
                </figure>
            </div>
            <div class="column is-two-thirds content">
                <slot></slot>
            </div>
        </div>
    </div>
</template>
