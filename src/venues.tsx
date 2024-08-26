import * as util from "./util";

export interface VenueProps {
  name: string;
  href: string;
  year?: string;
}

export class Venue extends util.WithPropsOf<VenueProps> {
  constructor(props: VenueProps) {
    super(props);
  }

  at_year(year: string, href: string): Venue {
    const props = this.cloneProps();
    props.year = year;
    props.href = href;
    return new Venue(props);
  }

  at_track(suffix: string): Venue {
    const props = this.cloneProps();
    props.name = `${props.name}${suffix}`;
    return new Venue(props);
  }

  jsx() {
    return (
      <a href={this.href} classList={util.hrefStyle}>
        [{this.name}{this.year? `'${this.year}` : ''}]
      </a>
    );
  }
}

// venues
export const tlaconf = new Venue({
  name: "TLA+Conf",
  href: "https://conf.tlapl.us/2024/",
});
export const icse = new Venue({
  name: "ICSE",
  href: "http://www.icse-conferences.org/",
});
export const srecon = new Venue({
  name: "SREcon",
  href: "https://www.usenix.org/srecon",
});
export const login = new Venue({
  name: ";login:",
  href: "https://www.usenix.org/publications/loginonline/",
});
export const asplos = new Venue({
  name: "ASPLOS",
  href: "https://asplos-conference.org/",
});
export const models = new Venue({
  name: "MODELS",
  href: "https://dl.acm.org/conference/models",
});
