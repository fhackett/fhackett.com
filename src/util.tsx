export const hrefStyle = {
  underline: true,
  "hover:no-underline": true,
};

export const proseStyle = {
  prose: true,
  "prose-zinc": true,
  "prose-headings:mb-3": true,
  "prose-hr:my-4": true,
};

export type WithPropsOf = {
  new <Props extends object>(props: Props): Props & { cloneProps(): Props };
};

export const WithPropsOf = class WithPropsOf<Props extends object> {
  constructor(props: Props) {
    Object.assign(this, props);
  }
  cloneProps() {
    return structuredClone(this);
  }
} as unknown as WithPropsOf;
