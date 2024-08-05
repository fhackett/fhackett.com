import { A } from "@solidjs/router";
import * as util from "../util";

export default function NotFound() {
  return (
    <main
      classList={{
        "mx-auto": true,
        "text-center": true,
        "content-center": true,
        "h-[75vh]": true,
        ...util.proseStyle,
      }}
    >
      <h1>[Not Found]</h1>
      <p classList={{ italic: true }}>I'm not sure how you got here...</p>
    </main>
  );
}
