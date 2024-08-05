import { A } from "@solidjs/router";
import { JSX } from "solid-js";

import * as util from "./util";

export interface AuthorProps {
  name: string;
  href?: string;
}

export class Author extends util.WithPropsOf<AuthorProps> {
  constructor(props: AuthorProps) {
    super(props);
  }

  jsx(): JSX.Element {
    if (this.href === "/") {
      return (
        <A href="/" classList={util.hrefStyle}>
          {this.name}
        </A>
      );
    } else if (this.href) {
      return (
        <a href={this.href} classList={util.hrefStyle}>
          {this.name}
        </a>
      );
    } else {
      return <>{this.name}</>;
    }
  }
}

export const finnHackett = new Author({
  name: "Finn Hackett",
  href: "/",
});
export const makuppe = new Author({
  name: "Markus Alexander Kuppe",
  href: "https://lemmster.de/",
});
export const joshuaRowe = new Author({
  name: "Joshua Rowe",
});
export const shayanh = new Author({
  name: "Shayan Hosseini",
  href: "https://shayanh.com/",
});
export const ruchitp = new Author({
  name: "Ruchit Palrecha",
});
export const yennisy = new Author({
  name: "Yennis Ye",
});
export const bestchai = new Author({
  name: "Ivan Beschastnikh",
  href: "https://www.cs.ubc.ca/~bestchai/",
});
export const renatocosta = new Author({
  name: "Renato Costa",
});
export const matthewdo = new Author({
  name: "Matthew Do",
  href: "https://minhdo.org/",
});
export const olhotak = new Author({
  name: "Ondřej Lhoták",
  href: "https://plg.uwaterloo.ca/~olhotak/",
});
export const rhackma = new Author({
  name: "Robert Hackman",
});
export const jmatlee = new Author({
  name: "Joanne M. Atlee",
  href: "https://cs.uwaterloo.ca/~jmatlee/",
});
export const migod = new Author({
  name: "Michael W. Godfrey",
  href: "https://plg.uwaterloo.ca/~migod/",
});
